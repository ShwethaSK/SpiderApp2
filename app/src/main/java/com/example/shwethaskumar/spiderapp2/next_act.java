package com.example.shwethaskumar.spiderapp2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Shwethaskumar on 15-Jun-17.
 */

public class next_act extends AppCompatActivity {
    LinearLayout mlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);
        Intent newPage = getIntent();
        String value = newPage.getStringExtra("textToBeDisplayed");
        mlayout = (LinearLayout) findViewById(R.id.new_layout);
        mlayout.addView(createNewTextView(value));
    }

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        return textView;
    }
}

