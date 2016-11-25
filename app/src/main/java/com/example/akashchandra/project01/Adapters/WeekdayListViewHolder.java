package com.example.akashchandra.project01.Adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.akashchandra.project01.Model.Weekday;
import com.example.akashchandra.project01.R;

/**
 * Created by Akash Chandra on 13-11-2016.
 */

public class WeekdayListViewHolder extends LinearLayout {

    Weekday data;
    Context context;

    public WeekdayListViewHolder(Context context) {
        super(context);
        this.context = context;
        setup();
    }

    public WeekdayListViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setup();
    }
    private void setup() {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.precip_card,this);
    }
    public void setData(Weekday weekday)
    {

        TextView WeekDayName = (TextView)findViewById(R.id.weekname);
        TextView Amount = (TextView)findViewById(R.id.humidityData);

        WeekDayName.setText(weekday.getWeekdayName());
        Amount.setText(weekday.getPrecipitationQty()+"%");
    }
}
