package com.example.sahil.fragmentdatapassing;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    private TextView mNameTV;
    private Button mSendPhoneBtn;
    private EditText mPhoneEt;
    private MainActivity mMainActivity;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mNameTV = (TextView) view.findViewById(R.id.name_tv);
        mPhoneEt = (EditText) view.findViewById(R.id.phone_et);
        mSendPhoneBtn = (Button) view.findViewById(R.id.sendphone_btn);

        mSendPhoneBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    mMainActivity = (MainActivity) getActivity();
                    mMainActivity.sendPhone(mPhoneEt.getText().toString());

            }
        });

        return view;
    }

    public void senddata(String s) {
            mNameTV.setText(s);
    }
}
