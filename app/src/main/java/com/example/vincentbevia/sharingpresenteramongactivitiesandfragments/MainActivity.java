package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        Contract.BalanceView, Contract.CallBack{

    private TextView MainTextView;
    private Contract.BalancePresenter contractPresenter;
    private Presenter presenter;
    private android.support.v4.app.FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private FrameLayout containerView;
    private Button ButtonPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainTextView = (TextView)findViewById(R.id.main_text_view);
        MainTextView.setText("Testing Presenter");
        containerView = (FrameLayout) findViewById(R.id.containerView);

        ButtonPanel = (Button) findViewById(R.id.buttonPanel);
        ButtonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToFragment();
                ButtonPanel.setText("FRAGMENT OPENED");
                ButtonPanel.setEnabled(false);

            }
        });
    }

    /**
     * This presenter is used by this activity and also by the fragment!
     */
    private void callPresenter() {
        presenter = new Presenter();
        presenter.setContext(this);
        presenter.setView(this);
        setPresenter(presenter);
        presenter.setView(this);

        presenter.letsCallTheShowText();
    }

    public void setPresenter (Contract.BalancePresenter contractPresenter){
        this.contractPresenter = contractPresenter;

    }

    private void goToFragment() {

        callPresenter();

        MainFragment secFrag = new MainFragment();
        android.app.FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.containerView, secFrag);
        fragTransaction.addToBackStack(null);
        fragTransaction.commit();

        containerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showText(String text) {
        MainTextView.setText("I've been called from presenter!");
    }

    /**
     * resetting everything when Fragment is closed!
     * Callback from fragment...
     */
    @Override
    public void methodToCallBack() {
        MainTextView.setText("Testing Presenter");
        ButtonPanel.setText("OPEN FRAGMENT");
        ButtonPanel.setEnabled(true);

        Toast.makeText(this, "Called back", Toast.LENGTH_SHORT).show();
    }
}
