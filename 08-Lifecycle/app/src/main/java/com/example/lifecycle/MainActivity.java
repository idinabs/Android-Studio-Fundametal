package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String Log_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Log_TAG, "====");
        Log.d(Log_TAG, "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Log_TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Log_TAG, "onResume");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(Log_TAG, "onRestart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Log_TAG, "onPause");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}