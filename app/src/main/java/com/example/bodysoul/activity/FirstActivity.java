package com.example.bodysoul.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    // 菜单栏
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "Add按钮", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove按钮", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        // 吐司按钮
        Button buttonone = (Button)findViewById(R.id.button_one);
        buttonone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "点击按钮", Toast.LENGTH_SHORT).show();
            }
        });
        // 退出按钮
        Button buttonback = (Button)findViewById(R.id.button_back);
        buttonback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 显式Intent按钮
        Button buttonintent = (Button) findViewById(R.id.button_intent);
        buttonintent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });
        // 隐式Intent按钮
        Button buttonyin = (Button) findViewById(R.id.button_ying);
        buttonyin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.bodysoul.activity.ACTION_START");
                intent.addCategory("com.example.bodysoul.activity.MY_CATEGORY");
                startActivity(intent);
            }
        });
        // Call Intent按钮
        Button buttoncall = (Button) findViewById(R.id.buton_call);
        buttoncall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10000"));
                startActivity(intent);
            }
        });
    }

}