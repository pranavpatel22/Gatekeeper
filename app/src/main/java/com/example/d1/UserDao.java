package com.example.d1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("Select * from User")
    List<User> getAllUsers();

    @Insert
    void insertUser(User user);
    @Update
    void updateUser(User user);
    @Delete
    void deletUser(User user);
    @Query("SELECT * FROM user ")
    LiveData<List<User>> getAllNotes();

    @Query("DELETE FROM User")
    void deleteAllNotes();


}
