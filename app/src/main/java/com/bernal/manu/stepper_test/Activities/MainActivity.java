package com.bernal.manu.stepper_test.Activities;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bernal.manu.stepper_test.Adapters.MyStepperAdapter;
import com.bernal.manu.stepper_test.Fragments.Test1Fragment;
import com.bernal.manu.stepper_test.Fragments.Test2Fragment;
import com.bernal.manu.stepper_test.Fragments.Test3Fragment;
import com.bernal.manu.stepper_test.R;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class MainActivity extends AppCompatActivity implements StepperLayout.StepperListener, Test1Fragment.OnFragmentInteractionListener,
        Test2Fragment.OnFragmentInteractionListener,Test3Fragment.OnFragmentInteractionListener{

    private StepperLayout mStepperLayout;
    private MyStepperAdapter mStepperAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperAdapter = new MyStepperAdapter(getSupportFragmentManager(), this);
        mStepperLayout.setAdapter(mStepperAdapter);
        mStepperLayout.setListener(this);
        setFragmentByDefault();
    }

    private void changeFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        getSupportActionBar().setTitle("Test");

    }

    private void setFragmentByDefault()
    {
        Test1Fragment fragment=new Test1Fragment();
        changeFragment(fragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCompleted(View completeButton) {
        Toast.makeText(this, "onCompleted! Activity 1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Toast.makeText(this, "onError! Activity 1 -> " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStepSelected(int newStepPosition) {
        Toast.makeText(this, "onStepSelected! Activity 1 -> " + newStepPosition, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReturn() {
        //finish();
    }

/*
    public void fragmentVisitasList() {
        idFragmentActual = 1;

        fragmentManager = getFragmentManager();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        VisitasListFragment fragment = new VisitasListFragment();
        idFm++;
        //idFm = 41;
        //fragmentID.push(idFm);
        //transaction.replace(R.id.content_frame, fragment);
        //transaction.commit();
        transaction.replace(R.id.content_frame,fragment)
                .addToBackStack(null).commit();
    }*/
}
