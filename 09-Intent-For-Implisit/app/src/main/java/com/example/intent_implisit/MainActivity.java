package com.example.intent_implisit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //method untuk menampung Website edit text
    private EditText websiteEditText;

    //method untuk menampung location edit text
    private EditText locationEditText;

    //method untuk menampung share edit text
    private EditText shareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void openWebsite(View view) {
        // find Id edit text open web
        websiteEditText = findViewById(R.id.editText_uri);

        //casting edit text to string
        String url = websiteEditText.getText().toString();

        //parse url edit text to URI Parse
        Uri webPage = Uri.parse(url);

        //intent to URI
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("implicitIntents","Maaf tidak bisa melakukan intent implisit ke website");
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void openLocation(View view) {

        //find id untuk location
        locationEditText = findViewById(R.id.editText_loc);

        //casting edit text to string
        String loc = locationEditText.getText().toString();

        //oarse url edit text to URI parse
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("implicitIntens", "Maaf tidak bisa melakukan intent ke maps");
        }
    }

    public void shareText(View view) {
        shareEditText = findViewById(R.id.editText_share);
        String share = shareEditText.getText().toString();
        String mimeType = "text/plan";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with")
                .setText(share)
                .startChooser();
    }
}