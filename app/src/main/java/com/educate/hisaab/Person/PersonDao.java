package com.educate.hisaab.Person;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface PersonDao {

    @Insert
    void insert(Person person);

    @Update
    Completable update(Person person);

    @Delete
    void delete(Person person);

    @Query("SELECT * FROM person")
    Single<List<Person>> getAllItems();
}
