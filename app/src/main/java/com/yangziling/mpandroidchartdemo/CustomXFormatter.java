package com.yangziling.mpandroidchartdemo;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * <b>Create Date:</b> 2018/1/16<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class CustomXFormatter implements IAxisValueFormatter {

    private String[] mValues;

    public CustomXFormatter(String[] values) {

        this.mValues = values;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        return mValues[(int) value % mValues.length];
    }

}
