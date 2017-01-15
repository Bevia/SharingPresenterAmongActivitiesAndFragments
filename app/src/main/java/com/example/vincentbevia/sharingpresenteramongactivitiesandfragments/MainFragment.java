package com.example.vincentbevia.sharingpresenteramongactivitiesandfragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements
        Contract.BalanceView {


    private TextView fragmentTextView;
    private TextView textToBeChanged;
    private Button fragmentButton;
    private Button fragmentButton1;
    Presenter presenter;
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

        textToBeChanged = (TextView) getActivity().findViewById(R.id.textToBeChanged);
        fragmentTextView = (TextView) getActivity().findViewById(R.id.fragmentTextView);
        fragmentTextView.setText("Fragment now active");

        fragmentButton = (Button) getActivity().findViewById(R.id.fragmentButton);
        fragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PresenterCaller(context, MainFragment.this);

            }
        });

        fragmentButton1 = (Button) getActivity().findViewById(R.id.fragmentButton1);
        fragmentButton1.setOnClickListener(new View.OnClickListener() {
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
        textToBeChanged.setText("I'm the Fragemnt, and I've been called from presenter!");

    }
}
