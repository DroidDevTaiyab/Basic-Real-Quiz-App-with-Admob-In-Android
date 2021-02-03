package com.techpassappmaster.realquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity {

    RelativeLayout btn_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Real Quiz");
        setSupportActionBar(toolbar);

        btn_play=findViewById(R.id.btn_play);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Main_Activity.this, Play_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.rate_us:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                break;

            case R.id.more_app:
                Toast.makeText(this, "more", Toast.LENGTH_SHORT).show();
                break;

            case R.id.privacy_policy:
                Toast.makeText(this, "pri", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
