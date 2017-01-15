package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;

import android.content.Context;

/**
 * Created by vincentbevia on 20/12/2016.
 */

public class Presenter implements
        Contract.BalancePresenter{

    private Contract.BalanceView view;
    private Context context;


    @Override
    public void setView(Contract.BalanceView view) {
        this.view = view;

    }

    public void setContext (Context context){
        this.context = context;

    }

    public void letsCallTheShowText() {
        this.view.showText("");
    }


}
