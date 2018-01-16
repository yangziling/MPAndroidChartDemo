package com.yangziling.mpchartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.yangziling.mpchartdemo.R.id.barChart;

/**
 * 这里引用的v2.2.3的包
 */
public class MainActivity extends AppCompatActivity {

    private BarChart mBarChart;
    public BarDataSet dataset;

    //数据集合
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

    //Y轴值
    public ArrayList<String> labels = new ArrayList<String>();
    private Button mShowChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mBarChart = (BarChart) findViewById(barChart);
        mShowChart = (Button) findViewById(R.id.showChart);
        mShowChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBarChart();
            }
        });

        //添加数据
        initEntriesData();

        //横轴的数据
        initLabData();

        //展示图表
        showBarChart();
    }

    //横轴数据初始化
    private void initLabData() {
        labels.add("一月");
        labels.add("二月");
        labels.add("三月");
        labels.add("四月");
        labels.add("五月");
        labels.add("六月");
        labels.add("七月");
        labels.add("八月");
        labels.add("九月");
        labels.add("十月");
        labels.add("十一月");
        labels.add("十二月");
    }

    //添加柱状图的数据
    private void initEntriesData() {
        entries.add(new BarEntry(400f, 0));
        entries.add(new BarEntry(800f, 1));
        entries.add(new BarEntry(600f, 2));
        entries.add(new BarEntry(1200f, 3));
        entries.add(new BarEntry(1800f, 4));
        entries.add(new BarEntry(900f, 5));
        entries.add(new BarEntry(500f, 6));
        entries.add(new BarEntry(600f, 7));
        entries.add(new BarEntry(700f, 8));
        entries.add(new BarEntry(1200f, 9));
        entries.add(new BarEntry(1900f, 10));
        entries.add(new BarEntry(2000f, 11));
    }

    //展示图标
    private void showBarChart() {
        //装载显示数据
        dataset = new BarDataSet(entries, "课程销量(套)");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        //封装x轴数据
        BarData data = new BarData(labels, dataset);

        //x轴属性设置
        XAxis xAxis = mBarChart.getXAxis();
        //默认X轴展示时空一个数
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setEnabled(true);
        //设置是否绘制网格线
        xAxis.setDrawGridLines(false);

        //Y轴属性设置
        YAxis yAxis = mBarChart.getAxisLeft();
        yAxis.setSpaceTop(10f);
        yAxis.setStartAtZero(true);
        yAxis.setLabelCount(6,false);

        //右侧Y轴关闭
        mBarChart.getAxisRight().setEnabled(false);
        //装载数据
        mBarChart.setData(data);
        mBarChart.animateY(2000);

        //设置右下角表文字
        mBarChart.setDescription("柱状图");
        //设置文字字号
        mBarChart.setDescriptionTextSize(8f);
        //设置表文字颜色
        mBarChart.setDescriptionColor(R.color.corlorBlack);

        //设置比例图
        Legend mLegend = mBarChart.getLegend();
        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);//设置显示位置
//        mLegend.setForm(Legend.LegendForm.DEFAULT);//设置比例图的形状，默认是方形

        //设置是否显示比例图
        mLegend.setEnabled(true);

    }


}
