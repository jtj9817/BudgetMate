package com.example.budgetmate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnItemSelected;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_AddGoal.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_AddGoal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_AddGoal extends Fragment {
    //Radio button check for
    @OnCheckedChanged({R.id.rbutton_creditPymnt, R.id.rbutton_Home, R.id.rButton_Car, R.id.rbutton_creditPymnt})
    public void onRadioButtonClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();

        // Check which radio button was clicked
        switch (radioButton.getId()) {
            case R.id.rbutton_creditPymnt:
                if (checked) {
                    // 1 clicked
                }
                break;
            case R.id.rbutton_Home:
                if (checked) {
                    // 2 clicked
                }
                break;
            case R.id.rButton_Car:
                if (checked) {
                    // 2 clicked
                }
                break;
            case R.id.rbutton_Other:
                if (checked) {
                    // 2 clicked
                }
                break;
        }
    }

    @BindView(R.id.editTxt_goalName)
    EditText GoalName;

    @BindView(R.id.ediTxt_duration)
    EditText GoalDuration;

    @BindView(R.id.editTxt_goalAmount)
    EditText GoalAmount;

    @OnItemSelected(R.id.spinner_goalDuration)
    public void spinnerItemSelected(Spinner spinner, int position)
    {

    }
    private OnFragmentInteractionListener mListener;

    public Fragment_AddGoal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_AddGoal.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_AddGoal newInstance(String param1, String param2) {
        Fragment_AddGoal fragment = new Fragment_AddGoal();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
