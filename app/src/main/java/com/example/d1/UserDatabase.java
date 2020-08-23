package com.example.d1;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = User.class,
        version = 1,
        exportSchema =false

)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase userDB = null;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getDBInstance(Context context) {
        if (userDB == null) {
            userDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class,
                    "user19b2").allowMainThreadQueries().build();
        }
        return userDB;
    }

}
