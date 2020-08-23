package com.example.d1.puser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class DataConveter {

    public static byte [] convertImage2ByteArray(Bitmap bitmap){

        ByteArrayOutputStream stream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,99,stream);
        return stream.toByteArray();
    }

    public static Bitmap convertByteArry2Image(byte [] arry){

        return BitmapFactory.decodeByteArray(arry,0,arry.length);
    }
}
