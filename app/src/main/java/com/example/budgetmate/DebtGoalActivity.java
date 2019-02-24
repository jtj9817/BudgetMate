package com.example.budgetmate;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.EditText;

import com.example.budgetmate.Models.Debt;

public class DebtGoalActivity extends AppCompatActivity {
    protected Debt usrDebt;
    @BindView(R.id.eTxtView_debtAmount)
    EditText debtAmount;
    @BindView(R.id.eTxtView_debtCurrentAmount)
    EditText debtCurrentAmount;
    @BindView(R.id.eTxtView_debtName)
    EditText debtName;
    @BindView(R.id.eTxtView_debtCmpndFrequency)
    EditText debtCmpndFreqncy;
    @BindView(R.id.eTxtView_debtInterestRate)
    EditText debtInterestRate;
    @OnClick(R.id.bttn_confirmDebtGoal)
    public void confirmDebtGoal()
    {
        //Perform additional debt calculations for last applied
        usrDebt.setActive(true);
        usrDebt.setDebtName(debtName.getText().toString());
        usrDebt.setDebtInitial(Double.parseDouble(debtAmount.getText().toString()));
        usrDebt.setDebtCurrent(Double.parseDouble(debtCurrentAmount.getText().toString()));
        usrDebt.setCompoundFrequency(Integer.parseInt(debtCmpndFreqncy.getText().toString()));
        usrDebt.setInterestRate(Double.parseDouble(debtInterestRate.getText().toString()));
    }
    @OnClick(R.id.bttn_cancelDebtGoal)
    public void cancelDebtGoal()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_goal);
    }
}
