package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aswin on 29-11-2017.
 */

public class TimeCollection extends AppCompatActivity {
    private Button btnVisualize;
    private EditText edtPt;
    private EditText edtOt;
    private EditText edtLt;

    private TextView txtP;
    private TextView txtC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_layout);

        Intent intent = getIntent();
        String project = intent.getExtras().getString("projectname");
        String company = intent.getExtras().getString("company");


        btnVisualize = (Button) findViewById(R.id.buttonVisualize);
        edtOt = (EditText) findViewById(R.id.editTextOt);
        edtPt = (EditText) findViewById(R.id.editTextPt);
        edtLt = (EditText) findViewById(R.id.editTextLt);

        txtP = (TextView) findViewById(R.id.textViewProject);
        txtC = (TextView) findViewById(R.id.textViewCompany);

        txtP.setText(project);
        txtC.setText(company);

        btnVisualize.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                Integer ot = Integer.valueOf(edtOt.getText().toString());
                Integer pt = Integer.valueOf(edtPt.getText().toString());
                Integer lt = Integer.valueOf(edtLt.getText().toString());


                Double pert = ((Double.valueOf(ot)+ 4*Double.valueOf(lt)+Double.valueOf(pt))/6);

                System.out.println("TOTAL BELOW: ");
                System.out.println(pert);


                Intent createIntent = new Intent(TimeCollection.this, TimeVisualization.class);
                createIntent.putExtra("ot",ot.toString());
                createIntent.putExtra("pt",pt.toString());
                createIntent.putExtra("lt",lt.toString());
                createIntent.putExtra("pert",pert.toString());
                startActivity(createIntent);

            }
        });




    }
}
