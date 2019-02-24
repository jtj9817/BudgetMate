package com.example.budgetmate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.bttn_AddGoal)
    public void addgGoal()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
