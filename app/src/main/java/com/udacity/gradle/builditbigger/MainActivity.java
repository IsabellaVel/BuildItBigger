package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.InterstitialAd;


import com.example.javajokes.Joker;
import com.example.jokesource.JokerActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    Joker myJoker = new Joker();
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

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

        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
            // Toast.makeText(this, jokeLibString, Toast.LENGTH_LONG).show();

        }else {
            Log.d(TAG, "The interstitial wasn`t loaded yet.");
        }
        Joker myJoker = new Joker();
        String jokeLibString = myJoker.getJoke();
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, jokeLibString));


/**        Intent intent = new Intent(this, JokerActivity.class);
 intent.putExtra(JokerActivity.JOKE_KEY, jokeLibString);
 startActivity(intent);
 **/
    }


}
