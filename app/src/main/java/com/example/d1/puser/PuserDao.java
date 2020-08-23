package com.example.d1.puser;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.d1.User;

import java.util.List;

@Dao
public interface PuserDao {
    @Query("Select * from Puser")
    List<Puser> getAllUsers();

    @Insert
    void insertUser(Puser puser);
    @Update
    void updateUser(Puser puser);
    @Delete
    void deletUser(Puser puser);
    @Query("SELECT * FROM Puser ")
    LiveData<List<Puser>> getAllNotes();

    @Query("DELETE FROM Puser")
    void deleteAllNotes();


}
