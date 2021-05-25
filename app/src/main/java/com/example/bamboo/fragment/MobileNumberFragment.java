package com.example.bamboo.fragment;

import android.content.Intent;
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
import android.widget.TextView;

import com.example.bamboo.R;
import com.example.bamboo.activity.HomeActivity;

public class MobileNumberFragment extends Fragment {
    //FirebaseAuth mAuth;
    String codeSent;
    EditText editTextLoginNumber;
    ImageView imageNext;
    TextView skip;
    public MobileNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile_number, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextLoginNumber = getView().findViewById(R.id.edit_text_login_number);
        skip=getView().findViewById(R.id.skip);
        imageNext = getView().findViewById(R.id.image_next);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createEditeTextLogin();
        createImageNext();
creatSkipText();



}

    private void creatSkipText() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             getActivity().startActivity(new Intent(getContext(), HomeActivity.class));
            }
        });
    }

    private void createImageNext() {
        imageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendVerificationCode();
            }
        });
    }
    private void sendVerificationCode() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_login, new MobileCodeFragment()).addToBackStack("back").commit();
        /*
        String phoneNumber =editTextLoginNumber.getText().toString();
        if (!phoneNumber.startsWith("5")){
            editTextLoginNumber.setError("Invalid Number");
            editTextLoginNumber.requestFocus();
            return;
        }
        phoneNumber=Constants.CODE_PALESTINE+phoneNumber;
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                getActivity(),               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
        Log.d("ttt",phoneNumber+">>*----");
*/
    }
    private void createEditeTextLogin() {
        editTextLoginNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 9) {
                    imageNext.setVisibility(View.VISIBLE);
                } else {
                    imageNext.setVisibility(View.GONE);

                }
            }
        });

    }
}

