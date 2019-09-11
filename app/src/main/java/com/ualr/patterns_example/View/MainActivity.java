package com.ualr.patterns_example.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ualr.patterns_example.Model.UserDatabase;
import com.ualr.patterns_example.Presenter.IPresenter;
import com.ualr.patterns_example.Presenter.Presenter;
import com.ualr.patterns_example.R;

public class MainActivity extends AppCompatActivity implements IView{

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mIdET;
    private EditText mNameET;
    private Button mRetrieveBtn;
    private Button mSaveBtn;
    private TextView mOutputUser;

    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(this);

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
        mPresenter.onSaveBtnClicked(userId, userName);
    }

    private void onRetrieveBtnClicked() {
        String userId = this.mIdET.getText().toString();
        mPresenter.onRetrieveBtnClicked(userId);
    }

    @Override
    public void updateWithRetrievedUser(String userName) {
        this.mOutputUser.setText(userName);
    }
}
