package com.example.bamboo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.bamboo.R;


public class MobileCodeFragment extends Fragment {
   // FirebaseAuth mAuth;
    String codeSent;
    ImageView imageNext;
    EditText editTextLoginNumberVerifyCode;



    public MobileCodeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moble_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageNext = getView().findViewById(R.id.image_next_verify_code);
        editTextLoginNumberVerifyCode = getView().findViewById(R.id.edti_text_veify_code);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        createImageNext();
        createEditeTextLogin();


    }

    private void createImageNext() {
        imageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                         getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out)
                        .replace(R.id.frame_login, new LoginNameAndEmailFragment())
                        .addToBackStack("back")
                        .commit();

             //   codeSent = getArguments().getString(Constants.SEND_CODE);
             //   verifySignInCode(codeSent);

            }
        });
    }

    private void createEditeTextLogin() {
        editTextLoginNumberVerifyCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 6) {
                    imageNext.setVisibility(View.VISIBLE);
                } else {
                    imageNext.setVisibility(View.GONE);

                }
            }
        });

    }

    private void verifySignInCode(String codeSent) {
/*
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, editTextLoginNumberVerifyCode.getText().toString());
        ;
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            getActivity().getSupportFragmentManager().beginTransaction().
                                    replace(R.id.frame_login, new LoginWithEmailFragment()).commit();

                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.d("ttt", "signInWithCredential:failure");

                        }
                    }
                });
*/
    }

}