package com.example.budgetmate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.budgetmate.Models.Goal;
import com.example.budgetmate.Network.NetworkManager;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class AddGoalActivity extends AppCompatActivity {
    private Goal userGoal;
    private NetworkManager networkManager;

    @BindView(R.id.editTxt_goalName)
    EditText GoalName;


    @BindView(R.id.editTxt_goalAmount)
    EditText GoalAmount;

    @OnClick(R.id.bttn_submit)
    public void submitGoal(Button button)
    {
        //Goal object populate
        userGoal.setActive(true);
        userGoal.setGoalName(GoalName.getText().toString());
        userGoal.setGoalAmount(Double.parseDouble(GoalAmount.getText().toString()));
        //Call GSON methods for converting Goal object into JSON here

    }

    @OnClick(R.id.bttn_cancel)
    public void cancelGoal(Button button)
    {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
    }
}
