package com.example.projectcmsc491;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class getBarCode {

    public static Bitmap getBar(int width, int height, String code){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try {
            BitMatrix bitmatrix = multiFormatWriter.encode(code, BarcodeFormat.CODE_128, width, height);

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    bitmap.setPixel(i, j, bitmatrix.get(i,j)? Color.BLACK:Color.WHITE);
                }
            }
            return bitmap;
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
    }

}
