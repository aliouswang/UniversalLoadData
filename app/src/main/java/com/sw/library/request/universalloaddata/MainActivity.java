package com.sw.library.request.universalloaddata;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.sw.library.request.mylibrary.UniversalLoadListener;
import com.sw.library.request.mylibrary.UniversalLoader;
import com.sw.library.request.mylibrary.mode.UniversalResult;
import com.sw.library.request.universalloaddata.mode.ActivityDetail;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = "loader";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "http://192.168.71.186:8081/ipark/inform/getactdetail.do?actid=1&userid=1&password=31a7b015d0f5c8ffbd23d3db5ac111d1";
                UniversalLoader.getDefault().loadData(MainActivity.this,
                        url, new UniversalLoadListener() {
                            @Override
                            public void preLoad() {

                            }

                            @Override
                            public void loadSuccess(String url, String response, UniversalResult result) {
                                UniversalResult<ActivityDetail> details
                                        = (UniversalResult<ActivityDetail>)result;
                                ArrayList<ActivityDetail> detailList = details.getResultList();
                                ActivityDetail detail = detailList.get(0);
                                Log.e(TAG, detail.toString());
                            }

                            @Override
                            public void loadFailed(String url, String response) {
                            }
                        },true, ActivityDetail.class);
            }
        });
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
}
