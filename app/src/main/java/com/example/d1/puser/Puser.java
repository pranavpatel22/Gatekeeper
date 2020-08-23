package com.example.d1.puser;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Puser")
public class Puser {
    @PrimaryKey(autoGenerate = true)
    int uid;
    @ColumnInfo(name = "Name")
    String Name;
    @ColumnInfo(name = "Number")
    String Number;
    @ColumnInfo(name = "Reason")
    String Reason;
    @ColumnInfo(name = "Place")
    String Place;
    @ColumnInfo(name = "Member")
    String Member;
    @ColumnInfo(name = "Gender")
    String Gender;
    @ColumnInfo(name = "VehicalD")
    String VehicalD;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte [] image;

    public int getUid() {
        return uid;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public String getReason() {
        return Reason;
    }

    public String getPlace() {
        return Place;
    }

    public String getMember() {
        return Member;
    }



    public String getVehiacalD() {
        return VehicalD;
    }

    public byte[] getImage() {
        return image;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public void setMember(String member) {
        Member = member;
    }



    public void setVehicalD(String vehicald) { VehicalD = vehicald; }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
