package com.example.projectcmsc491;


import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class GlobalClass {
    public static String className = "";
    public static String instructorName = "";
    public static String examName = "";
    public static ArrayList<ArrayList> gradesGlobal = new ArrayList<>();

    public static ArrayList<Bitmap> barcodes = new ArrayList<>();

    public static Dictionary<String, String> gradeDict = new Hashtable<>();

    public static String getClassName(){
        return className;
    }
    public static String getInstructorName(){
        return instructorName;
    }
    public static void setClassName(String newName){
        className = newName;
    }
    public static void setInstructorName(String newName){
        instructorName = newName;
    }
    public static void setExamName(String newName){examName = newName;}

    public static void addBarcode(Bitmap newCode){barcodes.add(newCode);}

    public static void updateGrade(String name, String grade){gradeDict.put(name, grade);};

}
