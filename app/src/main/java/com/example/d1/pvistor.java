package com.example.d1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.d1.puser.PuserDao;
import com.example.d1.puser.PuserDatabase;
import com.example.d1.puser.PuserRecycler;

public class pvistor extends AppCompatActivity {


    RecyclerView recyclerView;
    PuserDao puserDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvistor);
        recyclerView=findViewById(R.id.userRecyclerView);

        puserDao= PuserDatabase.getDBInstance(this).puserDao();


        final PuserRecycler puserRecycler =new PuserRecycler(puserDao.getAllUsers());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(puserRecycler);

    }



}