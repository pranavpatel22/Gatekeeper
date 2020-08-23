package com.example.d1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserRecycler extends RecyclerView.Adapter<UserViewHolder> {


    List<User> data;
    private List<User> users = new ArrayList<>();
    private Activity context;
    private UserDatabase database;


    public UserRecycler(List<User> data){

        this.data=data;
    }




    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_iteam,viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder userViewHolder, int position) {
        User user=data.get(position);
        database=UserDatabase.getDBInstance(context);
        userViewHolder.imageView.setImageBitmap(DataConveter.convertByteArry2Image(user.getImage()));
        userViewHolder.name.setText(user.getName());
        userViewHolder.number.setText(user.getNumber());
        userViewHolder.reason.setText(user.getReason());
        userViewHolder.place.setText(user.getPlace());
        userViewHolder.member.setText(user.getMember());

        userViewHolder.vehical.setText(user.getVehiacalD());
        userViewHolder.fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User d=data.get(userViewHolder.getAdapterPosition());
                database.userDao().deletUser(d);
                int position = userViewHolder.getAdapterPosition();
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



    public void setNotes(List<User> users) {
        this.users= users;
        notifyDataSetChanged();
    }

    public User getUserAt(int i) {
        return  users.get(i);
    }
}
