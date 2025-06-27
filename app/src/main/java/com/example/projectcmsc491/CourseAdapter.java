package com.example.projectcmsc491;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> studentIDs = new ArrayList<>();

    private LayoutInflater inflater;

    private SharedPreferences studentPrefs;

    public CourseAdapter(Context context, ArrayList<String> studentIDs) {
        this.context = context;
        this.studentIDs = studentIDs;
        inflater = LayoutInflater.from(context);
        studentPrefs = context.getSharedPreferences("CourseAuth", Context.MODE_PRIVATE);
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
        convertView = inflater.inflate(R.layout.activity_list_course_setup, null);
        TextView text = (TextView) convertView.findViewById(R.id.textViewCourseName);
        TextView text2 = (TextView) convertView.findViewById(R.id.textViewInstructorName);
        text.setText(studentIDs.get(position));
        text2.setText(studentPrefs.getString(studentIDs.get(position), "Error Student Not Found"));
        return convertView;
    }
}
