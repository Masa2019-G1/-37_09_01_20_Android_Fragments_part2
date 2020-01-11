package com.telran.a09_01_20_cw_part2;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordFragment extends Fragment implements View.OnClickListener {

    private EditText inputPassword;

    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_password, container, false);
        inputPassword = view.findViewById(R.id.inputPassword);

        Button backBtn = view.findViewById(R.id.backBtn);
        Button okBtn = view.findViewById(R.id.okBtn);

        backBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        requireContext().getSharedPreferences("SP", Context.MODE_PRIVATE);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backBtn){
            requireFragmentManager().popBackStack();
        }else if(v.getId() == R.id.okBtn){
            String password = inputPassword.getText().toString();
            Fragment emailFragment = requireFragmentManager().findFragmentByTag("EMAIL");
            Fragment welcomeFragment = requireFragmentManager().findFragmentByTag("WELCOME");
            String email = emailFragment.getArguments().getString("EMAIL");
            Bundle bundle = new Bundle();
            bundle.putString("EMAIL",email);
            bundle.putString("PASSWORD",password);
            welcomeFragment.setArguments(bundle);
            requireFragmentManager().popBackStack("ToEmail", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}
