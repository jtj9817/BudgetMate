package com.example.budgetmate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.OnClick;

public class GoalSummaryActivity extends AppCompatActivity {

    @OnClick(R.id.bttn_EditGoal)
    public void editGoal()
    {

    }

    @OnClick(R.id.bttn_DeleteGoal)
    public void deleteGoal()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_summary);
    }
}
