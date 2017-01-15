package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;

/**
 * Created by vincentbevia on 20/12/2016.
 */

public interface Contract {

    interface PresenterShowTextView {
    void showText(String text);

    }

    interface ContractPresenter {
        void setView(Contract.PresenterShowTextView view);

    }

    interface CallBack {
        void methodToCallBack();
    }
}
