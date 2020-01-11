package com.telran.a09_01_20_cw_part2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment implements View.OnClickListener {

    private EditText inputEmail;

    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_email, container, false);
        inputEmail = view.findViewById(R.id.inputEmail);
        Button backBtn = view.findViewById(R.id.backBtn);
        Button nextBtn = view.findViewById(R.id.nextBtn);

        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backBtn){
            requireFragmentManager().popBackStack();
        }else if(v.getId() == R.id.nextBtn){
            String email = inputEmail.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("EMAIL",email);
            setArguments(bundle);
            PasswordFragment fragment = new PasswordFragment();
            requireFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root,fragment)
                    .addToBackStack("ToPassword")
                    .commit();
        }
    }
}
