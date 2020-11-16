package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //    ActivityMainBinding mainBinding;
    private SharedPreferences sharedPreferences;


    private TextView currentNumberTextView;
    private TextView totalNumberTextView;

    private Button clearCurrentNumberButton;
    private Button clearTotalNumberButton;

    private Button countingButton;

    private int currentNumber = 0;
    private int totalNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
//        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        countingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentNumber++;
                totalNumber++;
                currentNumberTextView.setText(String.valueOf(currentNumber));
                totalNumberTextView.setText(String.valueOf(totalNumber));

              /*  editor.putString("name",mainBinding.textView.getText().toString());
                editor.putString("name2",mainBinding.textView2.getText().toString());editor.apply();*/
            }
        });

       /*mainBinding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                namea=sharedPreferences.getString("name","");
                mainBinding.textView.setText(namea);
                nameb=sharedPreferences.getString("name2","");
                mainBinding.textView2.setText(nameb);
            }
        });*/
        clearCurrentNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = 0;
                currentNumberTextView.setText(String.valueOf(currentNumber));
                /*editor.putString("name",mainBinding.textView.getText().toString());
                editor.putString("name2",mainBinding.textView2.getText().toString());
                editor.apply();*/
            }
        });

        clearTotalNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = 0;
                totalNumber = 0;
                currentNumberTextView.setText(String.valueOf(currentNumber));
                totalNumberTextView.setText(String.valueOf(totalNumber));
            }
        });

    }

    private void initViews() {
        currentNumberTextView = findViewById(R.id.current_number);
        totalNumberTextView = findViewById(R.id.total_number);
        clearCurrentNumberButton = findViewById(R.id.clear_current);
        clearTotalNumberButton = findViewById(R.id.clear_total);
        countingButton = findViewById(R.id.count_button);
    }

   /* @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("asd",mainBinding.textView.getText().toString());
        outState.putString("asd2",mainBinding.textView2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mainBinding.textView.setText(savedInstanceState.getString("asd"));
        mainBinding.textView2.setText(savedInstanceState.getString("asd2"));


        //,lmainViewModel.countA=Integer.parseInt(savedInstanceState.getString("asd"));
       // mainViewModel.countB=Integer.parseInt(savedInstanceState.getString("asd2"));
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        currentNumber = sharedPreferences.getInt("asd", 0);
        totalNumber = sharedPreferences.getInt("asd2", 0);

        totalNumberTextView.setText(String.valueOf(totalNumber));

        currentNumberTextView.setText(String.valueOf(currentNumber));


    }

    @Override
    protected void onStop() {
        super.onStop();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("asd", currentNumber);
        editor.putInt("asd2", totalNumber);
        editor.apply();
    }

}