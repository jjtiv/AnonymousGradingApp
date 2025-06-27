package com.example.projectcmsc491;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class scanPage extends AppCompatActivity implements View.OnClickListener{

    private static int code = 5;

    private Button myButton;
    private ImageView examScanner;
    private Button saveExam;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_page);
        myButton = (Button) findViewById(R.id.buttonTakePic);
        examScanner = (ImageView) findViewById(R.id.imageViewExamScan);
        saveExam = (Button) findViewById(R.id.buttonSaveExam);
        backBtn = (Button) findViewById(R.id.buttonBack);

        saveExam.setOnClickListener(this);
        backBtn.setOnClickListener(this);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(myIntent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonSaveExam){
            Intent saveEx = new Intent(scanPage.this, class1Page.class);
            startActivity(saveEx);
        }
        if(v.getId() == R.id.buttonBack){
            Intent goBack = new Intent(scanPage.this, class1Page.class);
            startActivity(goBack);
        }
    }

    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult o) {
                            if(o.getResultCode() == RESULT_OK){
                                Intent data = o.getData();
                                Bitmap image = (Bitmap) data.getExtras().get("data");
                                examScanner.setImageBitmap(image);
                            }
                        }
                    });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == code && resultCode == RESULT_OK){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            examScanner.setImageBitmap(image);
        }



    }
}