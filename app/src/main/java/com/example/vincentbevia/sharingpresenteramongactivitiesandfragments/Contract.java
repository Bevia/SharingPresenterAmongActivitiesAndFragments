package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;

/**
 * Created by vincentbevia on 20/12/2016.
 */

public interface Contract {

    interface BalanceView {
    void showText(String text);

    }

    interface BalancePresenter {
        void setView(Contract.BalanceView view);

    }

    interface CallBack {
        void methodToCallBack();
    }
}
