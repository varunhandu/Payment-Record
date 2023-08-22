package com.educate.hisaab.PersonInstance;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person_instance")
public class PersonInstance {
    @PrimaryKey(autoGenerate = true)
    long id;
    @ColumnInfo(name="person_id")
    long personid;

    public PersonInstance(long personid) {
        this.personid = personid;
    }
}
