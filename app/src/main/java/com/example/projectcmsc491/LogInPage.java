package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignInOptions;
import com.amplifyframework.auth.cognito.options.AuthFlowType;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class LogInPage extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private Button createAcc;

    private Button templog;
    private EditText tempuser,temppass;

    private Boolean isLoggedin = false;


    public static int code = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
        loginButton = (Button) findViewById(R.id.buttonLogin);
        createAcc = (Button) findViewById(R.id.buttonSignUp);
        templog = (Button) findViewById(R.id.buttonJonas);
        tempuser = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        temppass = (EditText) findViewById(R.id.editTextTextPassword2);

        loginButton.setOnClickListener(this);
        createAcc.setOnClickListener(this);
        templog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonLogin){
            Intent homepage = new Intent(LogInPage.this, homepage.class);
            startActivity(homepage);
        }
        if(v.getId() == R.id.buttonSignUp){
            Intent signUpInt = new Intent(LogInPage.this, SignUpPage.class);
            startActivity(signUpInt);
        }
        if(v.getId() == R.id.buttonJonas){

            AWSCognitoAuthSignInOptions options = AWSCognitoAuthSignInOptions.builder()
                    .authFlowType(AuthFlowType.USER_SRP_AUTH)
                    .build();
            Amplify.Auth.signIn(
                    tempuser.getText().toString(),
                    temppass.getText().toString(),
                    options,
                    result -> {
                        if (result.isSignedIn()) {
                            Log.i("AuthQuickstart", "Sign in succeeded!");
                            isLoggedin = true; // Update login status
                            Intent homepage = new Intent(LogInPage.this, homepage.class); // Use proper class name
                            startActivity(homepage);
                        } else {
                            Log.e("AuthQuickstart", "Sign in failed!");
                            Toast.makeText(LogInPage.this, "Sign in failed! Please check your username and password.", Toast.LENGTH_SHORT).show();
                        }
                    },
                    error -> Log.e("AuthQuickstart", error.toString())
            );
            //Log.i("AuthQuickstart", result.isSignedIn() ? "Sign in succeeded" : "Sign in not complete")
        }
    }
}