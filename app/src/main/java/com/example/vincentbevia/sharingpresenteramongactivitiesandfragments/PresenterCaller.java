package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;

import android.content.Context;

/**
 * Created by vbevia on 15/01/2017.
 */

public class PresenterCaller {

    private Contract.BalancePresenter contractPresenter;
    private Presenter presenter;
    private Context context;
    private MainActivity mainActivity;
    private MainFragment mainFragment;


    /**
     * Overloading constructors:
     * @param context
     * @param mainActivity
     */
    public PresenterCaller(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;

        callPresenterForActivity();
    }

    public PresenterCaller(Context context, MainFragment mainFragment) {
        this.context = context;
        this.mainFragment = mainFragment;

        callPresenterForFragment();
    }

    /**
     * This presenter is used by this activity and also by the fragment!
     */

    private void callPresenterForFragment() {
        presenter = new Presenter();
        presenter.setContext(context);
        presenter.setView(mainFragment);
        setPresenter(presenter);
        presenter.setView(mainFragment);
        presenter.letsCallTheShowText();
    }

    private void callPresenterForActivity() {
        presenter = new Presenter();
        presenter.setContext(context);
        presenter.setView(mainActivity);
        setPresenter(presenter);
        presenter.setView(mainActivity);
        presenter.letsCallTheShowText();
    }

    public void setPresenter (Contract.BalancePresenter contractPresenter){
        this.contractPresenter = contractPresenter;

    }
}
