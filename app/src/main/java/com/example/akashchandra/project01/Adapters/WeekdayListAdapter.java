package com.example.akashchandra.project01.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.akashchandra.project01.Model.Weekday;

import java.util.ArrayList;

/**
 * Created by Akash Chandra on 13-11-2016.
 */

public class WeekdayListAdapter extends BaseAdapter {
    ArrayList<Weekday> data = new ArrayList<>();
    Context context;

    public WeekdayListAdapter(ArrayList<Weekday> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        WeekdayListViewHolder weekdayListViewHolder = (WeekdayListViewHolder)view;
        if(weekdayListViewHolder == null)
        {
            weekdayListViewHolder = new WeekdayListViewHolder(context);
        }
        Weekday data = (Weekday)getItem(i);
        weekdayListViewHolder.setData(data);
        return weekdayListViewHolder;
    }
}
