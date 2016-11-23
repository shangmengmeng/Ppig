package com.story.ppig;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.story.ppig.view.BannerLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> bannerUrl = new ArrayList<>();
    private Integer[] ids = {R.drawable.pigxia, R.drawable.pigjiao, R.drawable.pigza};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BannerLayout bl = (BannerLayout) findViewById(R.id.pig);
        ViewGroup.LayoutParams lp = bl.getLayoutParams();
        int width = 100;
        lp.height = width * 9 / 20;
        ArrayList<Integer> bannerUrl = new ArrayList<>();
        bannerUrl.add(R.drawable.pigjiao);
        bannerUrl.add(R.drawable.pigxia);
        bannerUrl.add(R.drawable.pigza);
        bl.setViewRes(bannerUrl);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */





    @Override
    public void onStop() {
        super.onStop();

    }
}
