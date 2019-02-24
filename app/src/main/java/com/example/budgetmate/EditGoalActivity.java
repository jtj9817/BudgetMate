package com.example.budgetmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.budgetmate.Models.Goal;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class EditGoalActivity extends AppCompatActivity {
    private Goal userGoal;
    //Retrieve activity bundle that contains Goal data

    @BindView(R.id.editTxt_goalName_2)
    EditText GoalName;


    @BindView(R.id.editTxt_goalAmount_2)
    EditText GoalAmount;

    @OnClick(R.id.bttn_submit_2)
    public void submitGoal(Button button)
    {
    }

    @OnClick(R.id.bttn_cancel_2)
    public void cancelGoal(Button button)
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goal);
    }
}
