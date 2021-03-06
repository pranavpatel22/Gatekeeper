package com.example.d1;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserViewHolder extends RecyclerView.ViewHolder  {

    ImageView imageView;
    TextView name,number,reason,place,member,vehical;
    FloatingActionButton fb;
    MenuItem d;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.text_view_name);
        number=itemView.findViewById(R.id.text_view_mobile);
        reason=itemView.findViewById(R.id.text_view_reason);
        place=itemView.findViewById(R.id.text_view_place);
        member=itemView.findViewById(R.id.text_view_member);

        vehical=itemView.findViewById(R.id.text_view_vehical);
        imageView=itemView.findViewById(R.id.imageview);

        fb=itemView.findViewById(R.id.delete);


    }
}
