package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aswin on 29-11-2017.
 */

public class TimeVisualization extends AppCompatActivity {

    private BarChart barchart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timevis_layout);

        barchart = (BarChart) findViewById(R.id.barchart);

        Intent intent = getIntent();
        String ot = intent.getExtras().getString("ot");
        String pt = intent.getExtras().getString("pt");
        String lt = intent.getExtras().getString("lt");
        String pert = intent.getExtras().getString("pert");


        Float otf = Float.valueOf(ot);
        Float ptf = Float.valueOf(pt);
        Float ltf = Float.valueOf(lt);
        Float pertf = Float.valueOf(pert);


        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, otf.floatValue()));
        entries.add(new BarEntry(1f, ptf.floatValue()));
        entries.add(new BarEntry(2f, ltf.floatValue()));
        entries.add(new BarEntry(3f, pertf.floatValue()));


        BarDataSet set = new BarDataSet(entries, "Time Visualization");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barchart.setData(data);
        barchart.setFitBars(true); // make the x-axis fit exactly all bars
        barchart.invalidate();


    }
}
