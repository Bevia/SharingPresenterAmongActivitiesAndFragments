package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements
        Contract.PresenterShowTextView {


    private TextView FragmentTextView;
    private TextView TextToBeChanged;
    private Button FragmentTestPresenterButton;
    private Button CloseFragmentButton;
    final int version = Build.VERSION.SDK_INT;
    private Contract.CallBack callBack; //Composition here...I need this reference for callback!
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        callBack = (Contract.CallBack) getActivity();

        TextToBeChanged = (TextView) getActivity().findViewById(R.id.textToBeChanged);
        FragmentTextView = (TextView) getActivity().findViewById(R.id.fragmentTextView);
        FragmentTextView.setText("Fragment now active");

        FragmentTestPresenterButton = (Button) getActivity().findViewById(R.id.fragmentButton);
        CloseFragmentButton = (Button) getActivity().findViewById(R.id.fragmentButton1);

        //lets keep it nice for devices running lower versions ;)
        if (version < 23) {
            FragmentTestPresenterButton.setBackgroundColor( ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
            FragmentTestPresenterButton.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));

            CloseFragmentButton.setBackgroundColor( ContextCompat.getColor(getActivity(), android.R.color.holo_red_dark));
            CloseFragmentButton.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));
        }

        FragmentTestPresenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PresenterCaller(context, MainFragment.this);

            }
        });

        CloseFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call the method from MainActivity...
                callBack.methodToCallBack();
                //Close this fragment...
                getActivity().getFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public void showText(String text) {
        TextToBeChanged.setText("I'm the Fragemnt, and I've been called from presenter!");
    }
}
