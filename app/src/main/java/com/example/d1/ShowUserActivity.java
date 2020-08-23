package com.example.d1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;



public class ShowUserActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    UserDao userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        recyclerView=findViewById(R.id.userRecyclerView);

        userDAO=UserDatabase.getDBInstance(this).userDao();


        UserRecycler userRecycler =new UserRecycler(userDAO.getAllUsers());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userRecycler);



    }
}