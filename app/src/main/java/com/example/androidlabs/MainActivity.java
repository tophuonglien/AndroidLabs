package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ResourceBundle;


public class MainActivity extends AppCompatActivity {

    private ResourceBundle getResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        Toast.makeText(this, "Label has been updated", Toast.LENGTH_SHORT).show();

        String name = getResources.getString(String.valueOf(R.string.name));

        btn.setOnClickListener( (new OnClickListener(){

        //CheckBox.setOnClickListener(new CompoundButton.OnCheckedChangeListener)
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                String message = "The checkbox is now ";
                message += b ? "on" : "off";

                Snackbar.make(cb, message, Snackbar.LENGTH_LONG)
                        .setAction("Undo", new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                CheckBox.setChecked(!CheckBox.isChecked());
                            }

                        })
                        .show();
            }
        });
    }
}