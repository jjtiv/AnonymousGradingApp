package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

import java.util.concurrent.atomic.AtomicBoolean;

//import kotlin._Assertions;

public class SignUpPage extends AppCompatActivity implements View.OnClickListener{

    private EditText name;
    private EditText username;
    private EditText password;
    private Button nextBtn;


    private EditText tempuser, temppass, tempcode;
    private Button tempreg, tempcc;

    public static int code = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        name = (EditText) findViewById(R.id.editTextName);
        username = (EditText) findViewById(R.id.editTextUser);
        password = (EditText) findViewById(R.id.editTextPass);
        nextBtn = (Button) findViewById(R.id.buttonNext);

        tempuser =(EditText) findViewById(R.id.editTextTextEmailAddress);
        temppass =(EditText) findViewById(R.id.editTextTextPassword);
        tempcode =(EditText) findViewById(R.id.editTextNumber);
        tempreg =(Button) findViewById(R.id.buttonTempReg);
        tempcc =(Button) findViewById(R.id.buttonConfirmCode);

        nextBtn.setOnClickListener(this);
        tempreg.setOnClickListener(this);
        tempcc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonNext){
            Intent returnToLogin = new Intent(SignUpPage.this, MainActivity.class);
            String inputName = name.getText().toString();
            String inputUser = username.getText().toString();
            String inputPass = password.getText().toString();
            returnToLogin.putExtra("key1", inputName);
            returnToLogin.putExtra("key1", inputUser);
            returnToLogin.putExtra("key1", inputPass);
            startActivityForResult(returnToLogin, code);
        }
        if(v.getId() == R.id.buttonTempReg){
            AuthSignUpOptions options = AuthSignUpOptions.builder()
                    .userAttribute(AuthUserAttributeKey.email(), tempuser.getText().toString())
                    .build();
            Amplify.Auth.signUp(tempuser.getText().toString(),
                    temppass.getText().toString(), options,
                    result -> Log.i("Amplify Register", "Result" + result.toString()),
                    error -> Log.e("Amplify Register", "Result" + error.toString())
                    );
            tempcode.setVisibility(View.VISIBLE);
        }
        if(v.getId() == R.id.buttonConfirmCode){

            Amplify.Auth.confirmSignUp(
                    tempuser.getText().toString(),
                    tempcode.getText().toString(),
                    result -> {
                        if(result.isSignUpComplete()){
                            tempcode.setVisibility(View.INVISIBLE);
                            Intent returnToLogin = new Intent(SignUpPage.this, MainActivity.class);
                            startActivity(returnToLogin);
                        }else{
                            Log.e("AuthQuickstart", "Sign in failed!");
                            Toast.makeText(SignUpPage.this, "Sign in failed! Please check your username and password.", Toast.LENGTH_SHORT).show();
                        }

                    },
                    error -> Log.e("AuthQuickstart", error.toString())
            );
            //Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete")




        }
    }
}