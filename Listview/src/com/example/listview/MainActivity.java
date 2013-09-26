package com.example.listview;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.daylist.ColorEnum;
import com.example.daylist.Day;
import com.example.daylist.SimpleDate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
 
public class MainActivity extends Activity {
    private ListView lv;
    private CustomAdapter adapter ;
    private ArrayList<Day> fetch = new ArrayList<Day>();
    private GregorianCalendar cal = new GregorianCalendar();

 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.YEAR, 2013);
        Day day1 = new Day(cal,true,"Hola", ColorEnum.BLUE);
        day1.calculateFertilesDays();
        for(SimpleDate fecha : day1.getSimpleDatesList()) {}
        
        /*fetch.add(two);
        fetch.add(three);*/
        lv = (ListView) findViewById(R.id.listview);
        adapter = new CustomAdapter(MainActivity.this,
                R.id.listview,
                fetch);
        lv.setAdapter(adapter);
 
        
    }
 
}
