package com.bwei.heqianqian20181203;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.heqianqian20181203.database.FlowDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button btn_clean;
    private SearchActivity mainLayout;
    private List<String> list=new ArrayList<>();
    private SearchActivity.LayoutParams params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        final FlowDatabase flowDatabase=new FlowDatabase(this);
        List<String> data = flowDatabase.query();
        for (int i = 0; i <data.size() ; i++) {
            list.add(data.get(i));
            TextView textView = new TextView(MainActivity.this);
            mainLayout.addView(textView,params );
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new SearchActivity.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                String s = editText.getText().toString();
                list.add(s);
                TextView textView = new TextView(MainActivity.this);
                textView.setText(list.get(list.size()-1));
                textView.setTextSize(20);
                textView.setTextColor(Color.YELLOW);
                textView.setPadding(25,15,25,15);
                flowDatabase.insert(s);
                mainLayout.addView(textView, params);
            }
        });
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowDatabase.delete();
                mainLayout.removeAllViews();
            }
        });
    }

    private void initView() {
        editText = findViewById(R.id.edi_text);
        textView = findViewById(R.id.text_view);
        btn_clean = findViewById(R.id.btn_clean);
        mainLayout = findViewById(R.id.main_layout);

    }
}
