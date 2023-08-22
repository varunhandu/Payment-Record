package com.educate.hisaab;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.educate.hisaab.Person.Person;
import com.educate.hisaab.Person.PersonDao;
import com.educate.hisaab.PersonInstance.PersonInstance;
import com.educate.hisaab.PersonInstance.PersonInstanceDao;

@Database(entities = {Person.class, PersonInstance.class},version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
    public abstract PersonInstanceDao personInstanceDao();
    private static volatile PersonDatabase instance;

    public static synchronized PersonDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            PersonDatabase.class, "person_database")
                    .build();
        }
        return instance;
    }
}
