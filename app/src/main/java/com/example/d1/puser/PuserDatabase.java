package com.example.d1.puser;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.d1.User;
import com.example.d1.UserDao;

@Database(
        entities = Puser.class,
        version = 1,
        exportSchema =false

)
public abstract class PuserDatabase extends RoomDatabase {

    private static PuserDatabase puserDatabase = null;

    public abstract PuserDao puserDao();

    public static synchronized PuserDatabase getDBInstance(Context context) {
        if (puserDatabase == null) {
            puserDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PuserDatabase.class,
                    "Puser").allowMainThreadQueries().build();
        }
        return puserDatabase;
    }

}
