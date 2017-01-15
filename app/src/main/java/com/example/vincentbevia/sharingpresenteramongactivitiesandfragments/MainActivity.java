package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        Contract.PresenterShowTextView, Contract.CallBack {

    final int version = Build.VERSION.SDK_INT;
    private TextView MainTextView;
    private FrameLayout containerView;
    private Button OpenFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainTextView = (TextView) findViewById(R.id.main_text_view);
        MainTextView.setText("Testing Presenter");
        containerView = (FrameLayout) findViewById(R.id.containerView);

        OpenFragmentButton = (Button) findViewById(R.id.buttonPanel);
        //lets keep it nice for devices running lower versions ;)
        if (version < 23) {
            OpenFragmentButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
            OpenFragmentButton.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        }
        OpenFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToFragment();
                OpenFragmentButton.setText("FRAGMENT OPENED");
                OpenFragmentButton.setEnabled(false);

            }
        });
    }

    private void goToFragment() {

        new PresenterCaller(this, this);

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
        OpenFragmentButton.setText("OPEN FRAGMENT");
        OpenFragmentButton.setEnabled(true);

        Toast.makeText(this, "Called back", Toast.LENGTH_SHORT).show();
    }
}
