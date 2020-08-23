package com.example.d1.puser;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.d1.DataConveter;
import com.example.d1.R;
import com.example.d1.UserViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PuserRecycler extends RecyclerView.Adapter<PuserViewHolder> {


    List<Puser> data;
    private List<Puser> pusers = new ArrayList<>();
    private Activity context;
    private PuserDatabase database;


    public PuserRecycler(List<Puser> data){

        this.data=data;
    }




    @NonNull
    @Override
    public PuserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_iteam,viewGroup,false);
        return new PuserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PuserViewHolder puserViewHolder, int position) {
        Puser puser=data.get(position);
        database=PuserDatabase.getDBInstance(context);
        puserViewHolder.imageView.setImageBitmap(DataConveter.convertByteArry2Image(puser.getImage()));
        puserViewHolder.name.setText(puser.getName());
        puserViewHolder.number.setText(puser.getNumber());
        puserViewHolder.reason.setText(puser.getReason());
        puserViewHolder.place.setText(puser.getPlace());
        puserViewHolder.member.setText(puser.getMember());
        puserViewHolder.vehical.setText(puser.getVehiacalD());
        puserViewHolder.fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Puser d=data.get(puserViewHolder.getAdapterPosition());
                database.puserDao().deletUser(d);
                int position = puserViewHolder.getAdapterPosition();
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,data.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public void setNotes(List<Puser> pusers) {
        this.pusers= pusers;
        notifyDataSetChanged();
    }

    public Puser getUserAt(int i) {
        return  pusers.get(i);
    }
}
