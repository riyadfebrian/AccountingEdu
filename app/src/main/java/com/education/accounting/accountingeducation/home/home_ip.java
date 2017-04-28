package com.education.accounting.accountingeducation.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.education.accounting.accountingeducation.R;

public class home_ip  extends Fragment implements View.OnClickListener {


    private Button paham;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_ip, container, false);
        paham = (Button) rootView.findViewById(R.id.btn_sayamengerti);
        paham.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        if (v == paham) {
            getActivity().finish();
        }
    }
}
