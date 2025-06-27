package com.example.projectcmsc491;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScanInExam extends AppCompatActivity {

    Button mybtn;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_in_exam);
        mybtn = (Button) findViewById(R.id.meow);
        mybtn.setOnClickListener(v->
        {
            scanCode();

        });

    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Results:");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result->{
        if(result.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(ScanInExam.this);
            builder.setTitle("Results:");
            data = result.getContents();
            builder.setMessage(result.getContents());
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent i = new Intent(ScanInExam.this, ViewExam.class);
                    i.putExtra("VALUE", data);
                    startActivity(i);
                }
            }).show();
        }
    });
}