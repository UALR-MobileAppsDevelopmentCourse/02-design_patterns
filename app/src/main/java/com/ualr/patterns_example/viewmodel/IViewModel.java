package com.ualr.patterns_example.viewmodel;

/**
 * Created by irconde on 2019-09-10.
 */
public interface IViewModel {
    void onSaveBtnClicked(String userId, String userName);
    void onRetrieveBtnClicked(String userId);
}
