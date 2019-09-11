package com.ualr.patterns_example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ualr.patterns_example.Model.UserDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private UserDatabase usersDB;
    private EditText mIdET;
    private EditText mNameET;
    private Button mRetrieveBtn;
    private Button mSaveBtn;
    private TextView mOutputUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersDB = new UserDatabase();
        this.mIdET = findViewById(R.id.id_edit_text);
        this.mNameET = findViewById(R.id.name_edit_text);
        this.mOutputUser = findViewById(R.id.output_text_view);
        this.mRetrieveBtn = findViewById(R.id.retrieve_btn);
        this.mSaveBtn = findViewById(R.id.save_btn);

        this.mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveBtnClicked();
            }
        });

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
