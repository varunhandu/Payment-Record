package com.educate.hisaab;

import androidx.lifecycle.LiveData;

import com.educate.hisaab.Person.Person;
import com.educate.hisaab.Person.PersonDao;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PersonRepository {
    private PersonDao personDao;
    public Single<List<Person>> persons;

    public PersonRepository(PersonDao personDao){
        this.personDao = personDao;
        persons = personDao.getAllItems();
    }

    public Completable insertPerson(Person person){
        return Completable.fromAction(() -> personDao.insert(person))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable deletePerson(Person person){
        return Completable.fromAction(() -> personDao.delete(person))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable updatePerson(Person person){
        return Completable.fromAction(() -> personDao.update(person))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Single<List<Person>> getAllPersons(){
        return personDao.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
