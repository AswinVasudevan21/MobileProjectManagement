package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aswin on 28-11-2017.
 */
public class RevenueVisualization extends AppCompatActivity {

    private PieChart piechart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revenuevis_layout);

        Intent intent = getIntent();
        String q1p = intent.getExtras().getString("q1p");
        String q2p = intent.getExtras().getString("q2p");
        String q3p = intent.getExtras().getString("q3p");
        String q4p = intent.getExtras().getString("q4p");


        System.out.println("The string value is :");
        System.out.println(q1p);

        Float q1pf = Float.valueOf(q1p);
        Float q2pf = Float.valueOf(q2p);
        Float q3pf = Float.valueOf(q3p);
        Float q4pf = Float.valueOf(q4p);

        System.out.println("The Float value is :");
        System.out.println(q1pf);


        System.out.println("The float value is :");
        System.out.println(q1pf.floatValue());


        piechart = (PieChart) findViewById(R.id.piechart);

        //Integer q1p = Integer.valueOf(q1ps);

/*
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(q1p, "Green"));
        entries.add(new PieEntry(q2p, "Yellow"));
        entries.add(new PieEntry(q3p, "Red"));
        entries.add(new PieEntry(q4p, "Blue"));

        PieDataSet set = new PieDataSet(entries, "Quaterly Results");
        PieData data = new PieData(set);
        piechart.setData(data);
        piechart.invalidate(); // refresh


*/
        List<PieEntry> entries = new ArrayList<>();


        entries.add(new PieEntry(q1pf.floatValue(), "Q1"));
        entries.add(new PieEntry(q2pf.floatValue(), "Q2"));
        entries.add(new PieEntry(q3pf.floatValue(), "Q3"));
        entries.add(new PieEntry(q4pf.floatValue(), "Q4"));

        PieDataSet set = new PieDataSet(entries, "Revenue Results");
        PieData data = new PieData(set);

        final int[] MY_COLORS = {Color.rgb(192,0,0), Color.rgb(255,0,0), Color.rgb(255,192,0),
                Color.rgb(127,127,127), Color.rgb(146,208,80), Color.rgb(0,176,80), Color.rgb(79,129,189)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int c: MY_COLORS) colors.add(c);

        set.setColors(colors);

        piechart.setData(data);
        piechart.invalidate(); // refresh

    }
}
