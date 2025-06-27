package com.example.projectcmsc491;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] students;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, String[] students) {
        this.context = context;
        this.students = students;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return students.length;
    }

    @Override
    public Object getItem(int position) {
        return students[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_list_course_setup, null);
        TextView text = (TextView) convertView.findViewById(R.id.textViewCourseName);
        text.setText(students[position]);
        return convertView;
    }
}

