package com.example.projectcmsc491;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StudentExamAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> studentIDs = new ArrayList<>();
    private ArrayList<String> studentGrades = new ArrayList<>();

    private LayoutInflater inflater;

    private SharedPreferences studentPrefs;

    public StudentExamAdapter(Context context, ArrayList<String> studentIDs, ArrayList<String> studentGrades) {
        this.context = context;
        this.studentIDs = studentIDs;
        this.studentGrades = studentGrades;
        inflater = LayoutInflater.from(context);
        studentPrefs = context.getSharedPreferences("StudentAuth", Context.MODE_PRIVATE);
    }

    @Override
    public int getCount() {
        return studentIDs.size();
    }

    @Override
    public Object getItem(int position) {
        return studentIDs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_student_exam_list_setup, null);
        TextView text = (TextView) convertView.findViewById(R.id.textViewInstructorName);
        ImageView text2 = (ImageView) convertView.findViewById(R.id.imageView2);
        TextView text3 = (TextView) convertView.findViewById(R.id.textViewGrade);
        text.setText(studentPrefs.getString(studentIDs.get(position), "Error Student Not Found"));

        //Bitmap temp = getBarCode.getBar(text2.getWidth(), text2.getHeight(),studentPrefs.getString(studentIDs.get(position), "Error Student Not Found"));
        //GlobalClass.addBarcode(temp);

        text2.setImageBitmap(GlobalClass.barcodes.get(position));
        text3.setText(studentGrades.get(position));

        return convertView;
    }

}
