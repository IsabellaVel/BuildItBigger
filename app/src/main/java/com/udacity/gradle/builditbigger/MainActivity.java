package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.javajokes.Joker;
import com.example.jokesource.JokerActivity;


public class MainActivity extends AppCompatActivity {
    Joker myJoker = new Joker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, myJoker.getJoke()));
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

    public void tellJoke(View view) {

        Joker myJoker = new Joker();
        String jokeLibString = myJoker.getJoke();

        //Toast.makeText(this, jokeLibString, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, JokerActivity.class);
        intent.putExtra(JokerActivity.JOKE_KEY, jokeLibString);
        startActivity(intent);
    }


}
