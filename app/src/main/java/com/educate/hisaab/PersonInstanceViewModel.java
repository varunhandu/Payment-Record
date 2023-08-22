package com.educate.hisaab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.educate.hisaab.PersonInstance.PersonInstance;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class PersonInstanceViewModel extends AndroidViewModel {
    PersonInstanceRepository repo;
    Single<List<PersonInstance>> allPersonInstances;

    public PersonInstanceViewModel(@NonNull Application application) {
        super(application);
        repo = new PersonInstanceRepository(PersonDatabase.getInstance(application).personInstanceDao());
        allPersonInstances = repo.personInstances;
    }

    public Completable insertPersonInstance(PersonInstance personInstance) { return repo.inseertPersonInstace(personInstance);}
    public Completable deletePersonInstance(PersonInstance personInstance) { return repo.deletePersonInstance(personInstance);}
    public Single<List<PersonInstance>> getAllPersonInstances() { return  repo.getAllPersonInstances();}
}
