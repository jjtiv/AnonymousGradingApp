package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.ClassRoster;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signUpBtn;
    private Button loginBtn;

    private SharedPreferences students;
    private SharedPreferences.Editor studentEdit;
    public static String studentPref = "StudentAuth";

    private SharedPreferences courseSP;
    private SharedPreferences.Editor courseSPeditor;
    public static String coursePref = "CourseAuth";

    private SharedPreferences enrollSP;
    private SharedPreferences.Editor enrollSPeditor;
    public static String enrollPref = "EnrollAuth";

    private SharedPreferences examSP;
    private SharedPreferences.Editor examSPeditor;
    public static String examPref = "ExamAuth";
    public static int code = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUpBtn = (Button) findViewById(R.id.buttonSignUp);
        loginBtn = (Button) findViewById(R.id.buttonLogIn);


        Amplify.DataStore.query(
                ClassRoster.class,
                items -> {
                    while (items.hasNext()) {
                        ClassRoster item = items.next();
                        Log.i("Amplify", "Id " + item.getStudentId() + " Name " + item.getStudentName());
                        Amplify.DataStore.delete(item,
                                success -> Log.i("Amplify Test", "Deleted ClassRoster"),
                                failure -> Log.e("Amplify Test", "Error deleting ClassRoster", failure)
                        );
                    }
                    Log.i("IsLoopAliveIn", "deleted all");
                },
                failure -> Log.e("Amplify", "Could not query DataStore", failure)
        );

        Intent temp = getIntent();
        String hey = temp.getStringExtra("Key1");

        students = getSharedPreferences(studentPref, MODE_PRIVATE);
        studentEdit = students.edit();

        courseSP = getSharedPreferences(coursePref, MODE_PRIVATE);
        courseSPeditor = courseSP.edit();

        examSP = getSharedPreferences(examPref, MODE_PRIVATE);
        examSPeditor = examSP.edit();

        enrollSP = getSharedPreferences(enrollPref, MODE_PRIVATE);
        enrollSPeditor = enrollSP.edit();

        studentEdit.clear();
        studentEdit.commit();

        courseSPeditor.clear();
        courseSPeditor.commit();

        examSPeditor.clear();
        examSPeditor.commit();

        enrollSPeditor.clear();
        enrollSPeditor.commit();

        signUpBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSignUp){
            Intent toSignUp = new Intent(MainActivity.this, SignUpPage.class);
            startActivity(toSignUp);
        }
        if(v.getId() == R.id.buttonLogIn){
            Intent toLogIn = new Intent(MainActivity.this, LogInPage.class);
            startActivity(toLogIn);
        }
    }

}