package com.educate.hisaab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.educate.hisaab.Person.Person;
import com.educate.hisaab.Person.PersonDao;
import com.educate.hisaab.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Person> personList;
    public PersonViewModel pvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        personList = new ArrayList<>();
        PersonAdapter adapter = new PersonAdapter(personList);
        binding.recyclerView.setAdapter(adapter);
        pvm = new ViewModelProvider(this).get(PersonViewModel.class);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddNewPersonActivity.class));
            }
        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //PersonDatabase personDB = PersonDatabase.getInstance(this);
        //PersonDao personDao = personDB.personDao();
        //problem line. fix using async and threading. Rxjava
        //personList = personDao.getAllItems();
        //here we will place async functionality using repository and viewmodels

        pvm.getAllPersons().subscribe(
            persons -> {
                personList.clear();
                personList.addAll(persons);
                adapter.notifyDataSetChanged();
                //add an adapter method to bind the emitted data to the recyclerview
            },throwable -> {
                Log.e("RxJavaError", "An error occurred: " + throwable.getMessage());
            });


    }
}