package com.example.budgetmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.bttn_AddGoal)
    public void addGoal(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AddGoalActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.bttn_addDebtGoal)
    public void addDebtGoal(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DebtGoalActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
