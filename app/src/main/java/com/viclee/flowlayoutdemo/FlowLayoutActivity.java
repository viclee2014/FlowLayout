package com.viclee.flowlayoutdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class FlowLayoutActivity extends Activity implements View.OnClickListener {
    private String mNames[] = {"holidy", "shoot", "activity", "difference", "flow", "Lebron James",
            "ok", "android studio", "content", "strings", "padding", "child", "gradle", "back", "font", "turnoff"
    };
    private int namesLen = mNames.length;

    private FlowLayout mFlowLayout;
    private TextView addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);

        addBtn = (TextView)findViewById(R.id.add_flow_item_btn);
        addBtn.setOnClickListener(this);
        initChildViews();
    }

    private void initChildViews() {
        mFlowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        ViewGroup.LayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundResource(R.drawable.flow_layout_shape);
            mFlowLayout.addView(view, lp);
        }
    }

    private void addOneChildView() {
        ViewGroup.LayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView view = new TextView(this);
        view.setText(mNames[new Random().nextInt(namesLen)]);
        view.setTextColor(Color.WHITE);
        view.setBackgroundResource(R.drawable.flow_layout_shape);
        mFlowLayout.addView(view, lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_flow_item_btn:
                addOneChildView();
                break;
        }
    }
}
