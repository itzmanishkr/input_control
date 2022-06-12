package com.bnmit.inputcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    CheckBox ch1,ch2;
    RadioButton r1, r2;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);

        ch1 = (CheckBox) findViewById(R.id.checkBox);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
//        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(MainActivity.this, "You changed Male", Toast.LENGTH_SHORT).show();
//            }
//        });
//        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(MainActivity.this, "You changed Female", Toast.LENGTH_SHORT).show();
//            }
//        });



//        toggleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(toggleButton.isChecked()){
//                    Toast.makeText(MainActivity.this, "You turned on the button", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "You turned Off the button", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                StringBuffer onoff = new StringBuffer().append("on or off?");
                if(isChecked) {
                    onoff.append("ON");
                }
                else
                {
                    onoff.append("OFF");

                }
                Toast.makeText(MainActivity.this, onoff, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openAlert(View view) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Exit");
        myAlert.setMessage("Are you sure ?");
        myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        myAlert.setCancelable(false);
        myAlert.show();


    }

    public void openProgress(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Downloading");
        pd.setMessage("Please Wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        pd.show();
    }

    public void onSubmit(View view) {
        StringBuffer language = new StringBuffer().append(getString(R.string.checkbox_title));

        if(((CheckBox) findViewById(R.id.checkBox)).isChecked()) {
            language.append(getString(R.string.english));
        }
        if(((CheckBox) findViewById(R.id.checkBox2)).isChecked()) {
            language.append(getString(R.string.hindi));
        }

        Toast.makeText(this, language, Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", String.valueOf(language));
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton:
                Toast.makeText(MainActivity.this, "You changed Male", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(MainActivity.this, "You changed Female", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}