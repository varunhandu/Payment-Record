package com.educate.hisaab.PersonInstance;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.educate.hisaab.Person.Person;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface PersonInstanceDao {
    @Insert
    void insertPerson(PersonInstance person);

    @Delete
    void deletePerson(PersonInstance person);

    @Query("SELECT * FROM person_instance")
    Single<List<PersonInstance>> getAllItems();

}
