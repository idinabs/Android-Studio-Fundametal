package com.example.simpleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String Text_State = "currentText";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.TextView1);

        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(Text_State));
        }
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);

        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Text_State, mTextView.getText().toString());
    }

}