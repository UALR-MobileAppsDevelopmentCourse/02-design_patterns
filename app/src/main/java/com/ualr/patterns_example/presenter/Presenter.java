package com.ualr.patterns_example.presenter;

import com.ualr.patterns_example.model.UserDatabase;
import com.ualr.patterns_example.view.IView;

/**
 * Created by irconde on 2019-09-10.
 */
public class Presenter implements IPresenter {

    private UserDatabase model;
    private IView view;

    public Presenter(IView view) {
        this.model = new UserDatabase();
        this.view = view;
    }

    @Override
    public void onSaveBtnClicked(String userId, String userName) {
        if (userId.isEmpty() || userName.isEmpty()) return;
        this.model.addUser(userId, userName);
    }

    @Override
    public void onRetrieveBtnClicked(String userId) {
        String user = this.model.getUser(userId);
        view.updateWithRetrievedUser(user);
    }
}
