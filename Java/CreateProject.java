package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by aswin on 28-11-2017.
*/

public class CreateProject extends AppCompatActivity {

    private Button btnTime;
    private Button btnRevenue;
    private EditText edtProject;
    private EditText edtCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createproject_layout);
        btnTime = (Button) findViewById(R.id.buttonTime);
        btnRevenue = (Button) findViewById(R.id.buttonRevenue);

        edtProject = (EditText) findViewById(R.id.editTextProjectName);
        edtCompany = (EditText) findViewById(R.id.editTextCompanyname);


        btnTime.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent createIntent = new Intent(CreateProject.this, TimeCollection.class);
                createIntent.putExtra("projectname",edtProject.getText().toString());
                createIntent.putExtra("company",edtCompany.getText().toString());

                startActivity(createIntent);
            }
        });

        btnRevenue.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent createIntent = new Intent(CreateProject.this, RevenueCollection.class);
                createIntent.putExtra("projectname",edtProject.getText().toString());
                createIntent.putExtra("company",edtCompany.getText().toString());
                startActivity(createIntent);
            }
        });



    }
}

