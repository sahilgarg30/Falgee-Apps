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
public class FirstFragment extends Fragment {


    private View mChangeBtn;
    private MainActivity mMainActivity;
    private EditText mNameEt;
    private Button mSendBtn;
    private TextView mPhoneTv;
    private TextView mName1Tv;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mChangeBtn = view.findViewById(R.id.button);
        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity)getActivity();
                mMainActivity.change();

            }
        });
        mNameEt = (EditText) view.findViewById(R.id.name_et);
        mSendBtn = (Button) view.findViewById(R.id.send_btn);
        mPhoneTv = (TextView) view.findViewById(R.id.phone_tv);
        mName1Tv = (TextView) view.findViewById(R.id.name1_tv);
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity) getActivity();
                mMainActivity.send(mNameEt.getText().toString());
            }
        });
        return view;
    }

    public void sendPhone(String s) {
        mPhoneTv.setText(s);
    }

    public void sendname(String s) {
        mName1Tv.setText(s);
    }
}
