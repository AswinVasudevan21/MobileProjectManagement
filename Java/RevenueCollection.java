package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aswin on 28-11-2017.
 */


public class RevenueCollection extends AppCompatActivity {
    private Button btnVisualize;
    private EditText edtQ1;
    private EditText edtQ2;
    private EditText edtQ3;
    private EditText edtQ4;

    private TextView txtP;
    private TextView txtC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revenue_layout);

        Intent intent = getIntent();
        String project = intent.getExtras().getString("projectname");
        String company = intent.getExtras().getString("company");

        btnVisualize = (Button) findViewById(R.id.buttonVisualize);
        edtQ1 = (EditText) findViewById(R.id.editTextQ1);
        edtQ2 = (EditText) findViewById(R.id.editTextQ2);
        edtQ3 = (EditText) findViewById(R.id.editTextQ3);
        edtQ4 = (EditText) findViewById(R.id.editTextQ4);


        txtP = (TextView) findViewById(R.id.textViewProject);
        txtC = (TextView) findViewById(R.id.textViewCompany);

        txtP.setText(project);
        txtC.setText(company);


        btnVisualize.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //int q1 = Integer.parseInt(edtQ1.getText().toString());

                Integer q1 = Integer.valueOf(edtQ1.getText().toString());
                Integer q2 = Integer.valueOf(edtQ2.getText().toString());
                Integer q3 = Integer.valueOf(edtQ3.getText().toString());
                Integer q4 = Integer.valueOf(edtQ4.getText().toString());


                Integer total = q1+q2+q3+q4;

                System.out.println("TOTAL BELOW: ");
                System.out.println(total);

               Double q1p = Double.valueOf(q1) / Double.valueOf(total) * 100;
               Double q2p = Double.valueOf(q2) / Double.valueOf(total) * 100;
               Double q3p = Double.valueOf(q3) / Double.valueOf(total) * 100;
               Double q4p = Double.valueOf(q4) / Double.valueOf(total) * 100;

                System.out.println("Percentage value");
                System.out.println(q1p.toString());


                Intent createIntent = new Intent(RevenueCollection.this, RevenueVisualization.class);
                createIntent.putExtra("q1p",q1p.toString());
                createIntent.putExtra("q2p",q2p.toString());
                createIntent.putExtra("q3p",q3p.toString());
                createIntent.putExtra("q4p",q4p.toString());
                startActivity(createIntent);

            }
        });




    }
}
