package com.educate.hisaab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.educate.hisaab.Person.Person;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class PersonViewModel extends AndroidViewModel {

    PersonRepository repo;
    Single<List<Person>> allPersons;
    public PersonViewModel(@NonNull Application application) {
        super(application);
        repo = new PersonRepository(PersonDatabase.getInstance(application).personDao());
        allPersons = repo.persons;
    }

    public Completable insertPerson(Person person){
        return repo.insertPerson(person);
    }
    public Completable updatePerson(Person person){
        return repo.updatePerson(person);
    }
    public Completable deletePerson(Person person){
        return repo.deletePerson(person);
    }
    public Single<List<Person>> getAllPersons(){
        return repo.getAllPersons();
    }
}
