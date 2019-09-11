package com.ualr.patterns_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ualr.patterns_example.Model.User;
import com.ualr.patterns_example.Model.UserDatabase;

public class MainActivity extends AppCompatActivity {

    private UserDatabase usersDB;
    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mIdET;
    private EditText mNameET;
    private Button mRetrieveBtn;
    private Button mSaveBtn;
    private TextView mOutputUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 13: We can test is everything is ok with our model
        usersDB = new UserDatabase();
        // usersDB.addUser("IRC", "Ivan Rodriguez Code");
        // usersDB.addUser("JA", "John Appleseed");

        // TODO 14: Check what information is in our database in this moment. We'll use the logcat
        // User user = this.usersDB.getUser("JA");
        // Log.d(TAG, String.format("The user with the id %s is %s", user.getId(), user.getName()));
        // TODO 15: Obviously we can check that everything is ok debugging

        // TODO 16: We have to get the references to the text fields in the GUI in order to get data
        // provided by the user. Check that your textview elements have an id
        this.mIdET = findViewById(R.id.id_edit_text);
        this.mNameET = findViewById(R.id.name_edit_text);
        this.mOutputUser = findViewById(R.id.output_text_view);

        // TODO 17: We have to get a reference of each Button in the text field in order to define the
        // actions triggered in response to a click action
        this.mRetrieveBtn = findViewById(R.id.retrieve_btn);
        // TODO 18: Ctrl + D is very useful. We can duplicate a line
        this.mSaveBtn = findViewById(R.id.save_btn);

        // TODO 19: We have to define the code that is invoked when the user taps on each button
        this.mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveBtnClicked();
            }
        });

        // TODO 20: Maybe you don't remember all the methods of a class or interface...
        // Don't worry Ctrl + O comes to the rescue
        this.mRetrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRetrieveBtnClicked();
            }
        });
    }

    private void onSaveBtnClicked() {
        String userId = this.mIdET.getText().toString();
        String userName = this.mNameET.getText().toString();
        if (userId.isEmpty() || userName.isEmpty()) return;
        this.usersDB.addUser(userId, userName);
    }

    private void onRetrieveBtnClicked() {
        String userId = this.mIdET.getText().toString();
        String userName = this.usersDB.getUser(userId);
        this.mOutputUser.setText(userName);
    }

}
