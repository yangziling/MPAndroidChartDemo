package com.yangziling.mpandroidchartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
/**
 * 这里引用的v3.0.3的包
 */
public class MainActivity extends AppCompatActivity {

    private BarChart mBarChart;
    private Button mButton;
    public BarDataSet dataset;

    protected String[] values = new String[]{
            "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"
    };

    //数据集合
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBarChart = (BarChart) findViewById(R.id.barChart);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBarChart();
            }
        });

        //初始化添加的data数据
        initEntriesData();
        //展示图表
        showBarChart();

    }

    //初始化数据
    private void initEntriesData() {
        entries.add(new BarEntry(0f,400f));
        entries.add(new BarEntry(1f,800f));
        entries.add(new BarEntry(2f,600f));
        entries.add(new BarEntry(3f,1200f));
        entries.add(new BarEntry(4f,1800f));
        entries.add(new BarEntry(5f,900f));
        entries.add(new BarEntry(6f,500f));
        entries.add(new BarEntry(7f,600f));
        entries.add(new BarEntry(8f,700f));
        entries.add(new BarEntry(9f,1200f));
        entries.add(new BarEntry(10f,1900f));
        entries.add(new BarEntry(11f,2000f));

    }

    //展示图表
    private void showBarChart() {
        //装载显示数据
        dataset = new BarDataSet(entries, "课程销量(套)");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(dataset);
//        自定义X轴
        CustomXFormatter customXFormatter = new CustomXFormatter(values);

        //设置X轴的属性
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setEnabled(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setLabelCount(6,false);
        xAxis.setValueFormatter(customXFormatter);
        //设置是否绘制网格线
        xAxis.setDrawGridLines(false);

        //设置Y轴属性
        YAxis yAxis = mBarChart.getAxisLeft();
        yAxis.setStartAtZero(true);
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setLabelCount(6,false);

        //右侧Y轴关闭
        mBarChart.getAxisRight().setEnabled(false);
        mBarChart.animateY(2000);

        /**
         * 设置默认文字
         * 版本2.*版本的有可以直接设置的方法
         * 但是版本3.*我们可以在这里设置
         */
        Description description = new Description();
        description.setText("柱状图");
        mBarChart.setDescription(description);

        //设置比例图
        Legend mLegend = mBarChart.getLegend();
        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);//设置显示位置
        //设置是否显示比例图
        mLegend.setEnabled(true);

        mBarChart.setData(data);
        mBarChart.setFitBars(true);
        mBarChart.invalidate();
    }
}
