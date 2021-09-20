package com.ualr.patterns_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ualr.patterns_example.databinding.ActivityMainBinding;
import com.ualr.patterns_example.model.UserDatabase;

public class MainActivity extends AppCompatActivity {

    // TODO 04: We have to create an attribute of Activity class to hold a reference to the model.
    private UserDatabase usersDB;
    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());

        // TODO 05: Initialize the model
        usersDB = new UserDatabase();
        // usersDB.addUser("IRC", "Ivan Rodriguez Code");
        // usersDB.addUser("JA", "John Appleseed");

        // TODO 06: Check what information is in our database in this moment. We'll use the logcat
        // User user = this.usersDB.getUser("JA");
        // Log.d(TAG, String.format("The user with the id %s is %s", user.getId(), user.getName()));
        // TODO 07: Obviously we can check that everything is ok debugging

        // TODO 07: We have to define the code that is invoked when the user taps on each button
        this.mBinding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveBtnClicked();
            }
        });

        // TODO 07.B: Maybe you don't remember all the methods of a class or interface...
        // Don't worry Ctrl + O comes to the rescue
        this.mBinding.retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRetrieveBtnClicked();
            }
        });

        setContentView(mBinding.getRoot());

    }

    private void onSaveBtnClicked() {
        String userId = this.mBinding.idEditText.getText().toString();
        String userName = this.mBinding.nameEditText.getText().toString();
        if (userId.isEmpty() || userName.isEmpty()) return;
        this.usersDB.addUser(userId, userName);
    }

    private void onRetrieveBtnClicked() {
        String userId = this.mBinding.idEditText.getText().toString();
        String userName = this.usersDB.getUser(userId);
        this.mBinding.outputTextView.setText(userName);
    }

}
