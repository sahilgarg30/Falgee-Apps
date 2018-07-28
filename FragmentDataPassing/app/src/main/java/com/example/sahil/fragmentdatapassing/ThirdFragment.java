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
public class ThirdFragment extends Fragment {


    private TextView mNameTv;
    private Button mNameBtn;
    private EditText mNameEt;
    private MainActivity mMainAvtivity;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        mNameTv = (TextView) view.findViewById(R.id.name_tv);
        mNameEt = (EditText) view.findViewById(R.id.name1_et);
        mNameBtn = (Button) view.findViewById(R.id.sendname_btn);

        mNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainAvtivity = (MainActivity)getActivity();
                mMainAvtivity.sendname1(mNameEt.getText().toString());
            }
        });
        return view;
    }

    public void senddata(String s) {
        mNameTv.setText(s);
    }
}
