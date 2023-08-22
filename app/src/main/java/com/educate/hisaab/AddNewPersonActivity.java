package com.educate.hisaab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.educate.hisaab.Person.Person;
import com.educate.hisaab.PersonInstance.PersonInstance;
import com.educate.hisaab.databinding.ActivityAddNewPersonBinding;
import com.google.android.material.snackbar.Snackbar;

public class AddNewPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);
        ActivityAddNewPersonBinding binding = ActivityAddNewPersonBinding.inflate(getLayoutInflater());
        PersonViewModel pvm = new ViewModelProvider(this).get(PersonViewModel.class);
        PersonInstanceViewModel pivm = new ViewModelProvider(this).get(PersonInstanceViewModel.class);
        //PersonDatabase personDB = PersonDatabase.getInstance(this);
        //PersonDao personDao = personDB.personDao();
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(binding.submit,"created",Snackbar.LENGTH_LONG).show();
                String name = binding.addName.getText().toString();
                int debt = Integer.parseInt(binding.addDebt.getText().toString());
                Person pp = new Person(name,debt);
                pvm.insertPerson(pp);{
                    PersonInstance pi = new PersonInstance(pp.pid);
                    pivm.insertPersonInstance(pi);

                }
                //personDB.personDao().insert(
                //        new Person(name,debt)
                //);
                startActivity(new Intent(AddNewPersonActivity.this,MainActivity.class));
            }
        });


    }
}