package com.freeman.implicitintent.implicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MultiActionActivity extends AppCompatActivity {
    private TextView titleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_action);
        titleTxt = (TextView) findViewById(R.id.title_txt);
        String action = getIntent().getAction();
        if (action != null){
            if (action.equals("my.app.ashkelon.first.action")){
                titleTxt.setText("Was started with first action");
            }else if (action.equals("my.app.ashkelon.second.action")){
                titleTxt.setText("Was started with second action");
            }
        }
    }
}
