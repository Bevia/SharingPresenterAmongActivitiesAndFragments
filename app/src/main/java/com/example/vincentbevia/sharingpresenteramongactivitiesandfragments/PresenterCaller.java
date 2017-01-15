package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;

import android.content.Context;

/**
 * Created by vbevia on 15/01/2017.
 */

public class PresenterCaller {

    private Contract.ContractPresenter contractPresenter;
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

    public void setPresenter (Contract.ContractPresenter contractPresenter){
        this.contractPresenter = contractPresenter;
    }

    /**
     * This presenter is used by the MainActivity and also by the MainFragment!
     * You can keep on adding more "VIEWS" (Activities or Fragments) here.
     */

    private void callPresenterForActivity() {
        presenter = new Presenter();
        presenter.setContext(context);
        presenter.setView(mainActivity);
        setPresenter(presenter);
        presenter.setView(mainActivity);
        presenter.letsCallTheShowText();
    }

    private void callPresenterForFragment() {
        presenter = new Presenter();
        presenter.setContext(context);
        presenter.setView(mainFragment);
        setPresenter(presenter);
        presenter.setView(mainFragment);
        presenter.letsCallTheShowText();
    }
}
