package com.dsna20.particle201921079;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main201921079 extends AppCompatActivity
        implements RanGenFragment.OnFragmentInteractionListener,
        MinPQFragment.OnFragmentInteractionListener {

    RanGenFragment mRandGen;
    MinPQFragment mMinPQ;
    MinPQ<Double> mDouble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main201921079);
        mRandGen = new RanGenFragment();
        mMinPQ = new MinPQFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, mMinPQ).commit();
        mDouble = new MinPQ<Double>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main201921079, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.random:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, mRandGen).commit();
                break;
            case R.id.min_pq:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, mMinPQ).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
    public void onGenerateClick(View view) {
        EditText startText = (EditText) findViewById(R.id.start);
        EditText endText = (EditText) findViewById(R.id.end);
        String startString = startText.getText().toString().trim();
        String endString = endText.getText().toString().trim();
        if(!startString.isEmpty()){
            if(!endString.isEmpty()){
                double start = Double.valueOf(startString);
                double end = Double.valueOf(endString);
                String number = Double.toString(RandGen.uniform(start, end));
                TextView message = (TextView) findViewById(R.id.message1);
                message.append(number + "\n");
            }else {
                int end = Integer.valueOf(startString);
                String number = Integer.toString(RandGen.uniform(end));
                TextView message = (TextView) findViewById((R.id.message1));
                message.append(number + "\n");
            }
        }
    }
    public void onInsertClick(View view) {
        EditText entryText = (EditText) findViewById(R.id.entry);
        String entryString = entryText.getText().toString().trim();
        entryText.setText("");
        if (!entryString.isEmpty()){
            double entry = Double.valueOf(entryString);
            mDouble.insert(entry);
        }
    }
    public void onDeleteClick(View view) {
        if(!mDouble.isEmpty()){
            String entry = Double.toString(mDouble.delMin());
            TextView messages = (TextView) findViewById(R.id.message2);
            messages.append(entry + "\n");
        }
    }
}
