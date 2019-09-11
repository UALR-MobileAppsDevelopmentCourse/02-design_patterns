package com.ualr.patterns_example.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ualr.patterns_example.presenter.IPresenter;
import com.ualr.patterns_example.presenter.Presenter;
import com.ualr.patterns_example.R;

// TODO 0: Who is who in the MVP pattern
/*
    The presenter is a kind intermediary between the view and the model
    The view will only be in charge of updating the GUI elements (for example, updating the text label with the name of the retrieved user)
    The view notifies the presenter events triggered from GUI (for example, user tap on "Add" button)
    In response to the event, the presenter asks to the model to update (adding the new user data)
    At the same time, the presenter updates the view in order to display the new information (retrieving an existing user)
 */

// TODO 0. Relationship among the different elements in the MVP pattern

// The view has to have a reference of the presenter in order to notify the events
// The presenter has a reference both of the view and the model:
//  + Asks the model to update
//  + Gets data from the model
//  + Asks the view to update with new data retrieved from the model

// TODO 01. Define an interface for the View. We must include methods that are going to be called from the presenter
// TODO 02. Define an interface for the presenter. We must include methods that are going to be called from the view
// TODO 03. Create a presenter class that implements the presenter interface.
// TODO 04. Remember: Include in the presenter class a reference to the view and a reference to the model
// TODO 05. Remember: We must include in the presenter as much logic as we can. So it will in charge of creating the model instance
// TODO 06. Implement in the Activity (since it's our view class) the methods defined in the view interface
// TODO 07. Remember: Include in the view class (the activity) a reference to the presenter.

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
