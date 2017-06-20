package com.example.shwethaskumar.spiderapp2;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout mlayout;
    EditText mEditText;
    Button mButton;
    int m=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mlayout=(LinearLayout) findViewById(R.id.linear1);
        mEditText=(EditText)findViewById(R.id.textView3);
        mButton=(Button)findViewById(R.id.button3);
        TextView textView=new TextView(this);
        textView.setText("New Text");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addText(View view) {
        mlayout.addView(createNewTextView(mEditText.getText().toString()));
    }
    private TextView createNewTextView(final String text)
    {

        final LinearLayout.LayoutParams lparams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView=new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(25);
        textView.setTextColor(Color.MAGENTA);
        textView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent newPage=new Intent(view.getContext(),next_act.class);
                newPage.putExtra("textToBeDisplayed",text);
                startActivity(newPage);
            }
        });
        mEditText.setText("");
        return textView;
    }

 public void removeText(View view){
     if(m==0) {
         Toast.makeText(this, "Enter position in textbox and click button again", Toast.LENGTH_LONG).show();
         m = 1;
     } else if (m == 1 ) {
         int pos = Integer.parseInt(mEditText.getText().toString());
         if (mlayout.getChildAt(pos + 1) instanceof TextView)
             mlayout.removeView(mlayout.getChildAt(pos + 1));
         else
             Toast.makeText(this, "No item in specified position", Toast.LENGTH_LONG).show();
         m = 0;
     }
 }
}