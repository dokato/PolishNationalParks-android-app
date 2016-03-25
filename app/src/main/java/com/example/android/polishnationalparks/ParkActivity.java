package com.example.android.polishnationalparks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ParkActivity extends AppCompatActivity {

    String urlAddress;
    String parkNationalName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        String buttonId;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                buttonId= null;
            } else {
                buttonId= extras.getString("id");
            }
        } else {
            buttonId= (String) savedInstanceState.getSerializable("id");
        }
        Log.v("LOG", "button id: " + buttonId);

        ImageView parkImg = (ImageView) findViewById(R.id.park_img);
        TextView parkName = (TextView) findViewById(R.id.park_name);
        TextView parkInfo = (TextView) findViewById(R.id.park_description);
        TextView parkUrl = (TextView) findViewById(R.id.park_url);

        int resourceId = this.getResources().getIdentifier("p"+buttonId, "drawable", getPackageName());
        parkImg.setImageResource(resourceId);
        Log.v("BUTTON:", "park" + buttonId);
        int resnameId = this.getResources().getIdentifier("park"+buttonId, "string",  getPackageName());
        parkName.setText(getString(resnameId));
        parkNationalName = getString(resnameId);
        resnameId = this.getResources().getIdentifier("park"+buttonId+"_info", "string",  getPackageName());
        parkInfo.setText(getString(resnameId));
        resnameId = this.getResources().getIdentifier("park"+buttonId+"_url", "string",  getPackageName());
        parkUrl.setText(getString(resnameId));
        urlAddress = getString(resnameId);
    }

    //Open url after clicking a link
    public void onUrlClick(View view){
        Uri uri = Uri.parse(urlAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    //Open map and search for park
    public void onButtonMap(View view){
        String parsedName = parkNationalName.replace(' ', '+');
        Intent geoIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + parsedName));
        startActivity(geoIntent);
    }

}
