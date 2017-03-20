package com.freeman.implicitintent.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sendFirstActionBtn, sendSecondActionBtn, openLinkBtn, callBtn, showMapBtn, sendMailBtn, showMyMapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendFirstActionBtn = (Button) findViewById(R.id.send_first_action_btn);
        sendSecondActionBtn = (Button) findViewById(R.id.send_second_action_btn);
        openLinkBtn = (Button) findViewById(R.id.open_link_btn);
        callBtn = (Button) findViewById(R.id.call_btn);
        showMapBtn = (Button) findViewById(R.id.show_map_btn);
        sendMailBtn = (Button) findViewById(R.id.send_mail_btn);
        showMyMapBtn = (Button) findViewById(R.id.show_my_map_btn);
        sendFirstActionBtn.setOnClickListener(this);
        sendSecondActionBtn.setOnClickListener(this);
        openLinkBtn.setOnClickListener(this);
        callBtn.setOnClickListener(this);
        showMapBtn.setOnClickListener(this);
        sendMailBtn.setOnClickListener(this);
        showMyMapBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_first_action_btn){
            Intent intent = new Intent("my.app.ashkelon.first.action");
            startActivity(intent);
        }else if (v.getId() == R.id.send_second_action_btn){
            Intent intent = new Intent("my.app.ashkelon.second.action");
            startActivity(intent);
        }else if (v.getId() == R.id.open_link_btn){
            Uri uri = Uri.parse("http://google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);

            Intent chooser = Intent.createChooser(intent, "Choice browser!");
            startActivity(chooser);
        }else if (v.getId() == R.id.call_btn){
            Uri uri = Uri.parse("tel: 0547099959");
//            Intent intent = new Intent(Intent.ACTION_CALL);
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(uri);

            Intent chooser = Intent.createChooser(intent, "Choice ...");
            startActivity(chooser);
        }else if (v.getId() == R.id.show_map_btn){
            Uri uri = Uri.parse("geo:55.754283,37.62002");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);

            Intent chooser = Intent.createChooser(intent, "Choice your map");
            startActivity(chooser);
        }else if (v.getId() == R.id.send_mail_btn){
            Uri uri = Uri.parse("mailto:");
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(uri);
            String[] to = {"sheygam@gmail.com", "vasya@pupkin.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Email from my app");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello world");
            intent.setType("message/rfc833");

            Intent chooser = Intent.createChooser(intent, "Choice mail app");
            startActivity(chooser);
        }else if (v.getId() == R.id.show_my_map_btn){
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
    }
}
