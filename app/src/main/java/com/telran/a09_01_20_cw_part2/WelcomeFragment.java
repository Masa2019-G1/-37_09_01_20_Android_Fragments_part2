package com.telran.a09_01_20_cw_part2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment implements View.OnClickListener {
    private String email = "";
    private String password = "";

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        TextView emailTxt = view.findViewById(R.id.emailTxt);
        TextView passwordTxt = view.findViewById(R.id.passwordTxt);
        Bundle bundle = getArguments();

        if(bundle != null) {
            emailTxt.setText(bundle.getString("EMAIL",""));
            passwordTxt.setText(bundle.getString("PASSWORD",""));
        }

        Button nextBtn = view.findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.nextBtn){
            EmailFragment fragment = new EmailFragment();
            requireFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root,fragment,"EMAIL")
                    .addToBackStack("ToEmail")
                    .commit();
        }
    }
}
