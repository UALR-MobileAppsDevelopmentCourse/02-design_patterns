package com.ualr.patterns_example.viewmodel;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.ualr.patterns_example.model.UserDatabase;

/**
 * Created by irconde on 2019-09-10.
 */
public class UserViewModel implements IViewModel {

    private UserDatabase model;
    // TODO 01.02: Reference to the view is no longer desirable. Remove it from the UserViewModel
    // TODO 03.05. We have to create bindings for the different values we want to manage from viewmodel
    // TODO 03.06. We have to define these values as observable in order to get their updated value anytime

    public final ObservableField<String> userId = new ObservableField<>();
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> output = new ObservableField<>();

    public UserViewModel() {
        this.model = new UserDatabase();
    }

    @Override
    public void onSaveBtnClicked(String userId, String userName) {
        if (userId.isEmpty() || userName.isEmpty()) return;
        this.model.addUser(userId, userName);
    }

    @Override
    public void onRetrieveBtnClicked(String userId) {
        String user = this.model.getUser(userId);
        output.set(user);
    }
}
