package com.educate.hisaab;

import com.educate.hisaab.PersonInstance.PersonInstance;
import com.educate.hisaab.PersonInstance.PersonInstanceDao;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PersonInstanceRepository {
    PersonInstanceDao personInstanceDao;
    Single<List<PersonInstance>> personInstances;
    PersonInstanceRepository (PersonInstanceDao personInstanceDao){
        this.personInstanceDao = personInstanceDao;
        this.personInstances = personInstanceDao.getAllItems();
    }
    public Completable inseertPersonInstace(PersonInstance personInstance){
        return Completable.fromAction(() -> personInstanceDao.insertPerson(personInstance))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Completable deletePersonInstance(PersonInstance personInstance){
        return Completable.fromAction(() -> personInstanceDao.deletePerson((personInstance)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Single<List<PersonInstance>> getAllPersonInstances(){
        return personInstanceDao.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
