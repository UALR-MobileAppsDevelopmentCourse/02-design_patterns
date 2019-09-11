package com.ualr.patterns_example.Presenter;

/**
 * Created by irconde on 2019-09-10.
 */
public interface IPresenter {
    void onSaveBtnClicked(String userId, String userName);
    void onRetrieveBtnClicked(String userId);
}
