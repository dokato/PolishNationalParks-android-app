package com.example.android.polishnationalparks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainlayout = (LinearLayout) findViewById(R.id.linlayout);
        Intent intent = new Intent(MainActivity.this, ParkActivity.class);

        for(int i=1; i <= 23; i++) // where x is the size of the list containing your alphabet.
        {
            final Button button = new Button(this);
            button.setId(i);
            int resId = getResources().getIdentifier("park"+i, "string",  getPackageName());
            button.setText(getString(resId));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ParkActivity.class);
                    intent.putExtra("id", ""+button.getId());
                    MainActivity.this.startActivity(intent);
                }
            });
            mainlayout.addView(button);
        }
        //Intent i = new Intent(MainActivity.this, ParkActivity.class);
        //MainActivity.this.startActivity(i);
    }

    public void appInfo(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Polish National Parks");
        alertDialog.setMessage(getString(R.string.app_info));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
