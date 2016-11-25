package com.example.akashchandra.project01.HomeFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.akashchandra.project01.Adapters.WeekdayListAdapter;
import com.example.akashchandra.project01.Model.Weekday;
import com.example.akashchandra.project01.R;

import java.util.ArrayList;

/**
 * Created by Akash Chandra on 11-11-2016.
 */

public class Precipitation extends Fragment {
    ArrayList<Weekday> weekdays = new ArrayList<>();
    ListView lvList;
    WeekdayListAdapter weekdayListAdapter;
    Weekday weekday;

    public Precipitation()
    {
        //Empty Constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_precipitation,container,false);
        lvList = (ListView)view.findViewById(R.id.prepitation_data);
        weekdayListAdapter = new WeekdayListAdapter(weekdays,getActivity());
        lvList.setAdapter(weekdayListAdapter);
        //lvList.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        weekday = new Weekday("Monday","0");
        weekdays.add(weekday);
        weekday = new Weekday("Tuesday","0");
        weekdays.add(weekday);
        weekday = new Weekday("Wednesday","0");
        weekdays.add(weekday);
        weekday = new Weekday("Thursday","0");
        weekdays.add(weekday);
        weekday = new Weekday("Friday","0");
        weekdays.add(weekday);
        weekday = new Weekday("Saturday","0");
        weekdays.add(weekday);
        weekday = new Weekday("Sunday","0");
        weekdays.add(weekday);
        weekdayListAdapter.notifyDataSetChanged();
        return view;
    }
}
