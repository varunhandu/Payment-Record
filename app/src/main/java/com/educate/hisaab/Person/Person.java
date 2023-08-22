package com.educate.hisaab.Person;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    public long pid;
    @ColumnInfo(name = "person_name")
    public String name;
    @ColumnInfo(name = "person_debt")
    public int debt;

    public Person(String name, int debt) {
        this.name = name;
        this.debt = debt;
    }

//    public long getPid() {
//        return pid;
//    }

    public String getName() {
        return name;
    }

    public int getDebt() {
        return debt;
    }
}
