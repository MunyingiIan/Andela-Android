package com.aimdevelopers.munyingiian.andela;

/**
 * Created by Munyingi Ian
 */

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    private Runnable mRepeatRunnable;

    SwipeRefreshLayout mSwipeRefreshLayout;

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get JSON
    private static String url = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD,EUR,NGN,KES,AUD,AFN,ALL,DZD,AOA,XCD,ARS,AZN,BSD,BAM,BOB,BND,CZK,CAD,COP,BIF,VEF";

    ArrayList<HashMap<String, String>> exchangeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        handler = new Handler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //recreate activity on refresh
                recreate();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        exchangeList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetExachngerate().execute();

        handler.postDelayed(runnable, 10000);
    }
    private Runnable runnable = new Runnable() {
        public void run() {
                // recreate activity every 10 seconds
                recreate();
            handler.removeCallbacks(runnable);
        }
    };

    @Override
    protected void onDestroy(){
        super.onDestroy();

        handler.removeCallbacks(runnable);
    }




    /**
     * Async task class to get json by making HTTP call
     */
    private class GetExachngerate extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    for (int i = 0; i < 20; i++) {
                        if(i == 0){
                        // Getting JSON Array node
                        String Value = jsonObj.getString("NGN");

                        // tmp hash map for single exchange
                        HashMap<String, String> exchange = new HashMap<>();

                        exchange.put("Name", "Nigerian - Naira");
                        exchange.put("Code", "NGN");
                        exchange.put("Value", Value);


                        // adding exchange to exchange list
                        exchangeList.add(exchange);
                        }else if(i == 1){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("USD");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "USA - US Dollars");
                            exchange.put("Code", "USD");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 2){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("EUR");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "European - Euro");
                            exchange.put("Code", "EUR");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 3){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("KES");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "Kenyan - Shillings");
                            exchange.put("Code", "KES");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 4){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("AUD");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "Australian - Dollar");
                            exchange.put("Code", "AUD");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 5){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("AFN");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "AFGHANISTAN - Afghani");
                            exchange.put("Code", "AFN");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 6){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("ALL");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "ALBANIA - Lek");
                            exchange.put("Code", "ALL");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 7){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("DZD");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "ALGERIA - Algerian Dinar");
                            exchange.put("Code", "DZD");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 8){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("AOA");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "ANGOLA - Kwanza");
                            exchange.put("Code", "AOA");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 9){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("ARS");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "ARGENTINA - Argentine Peso");
                            exchange.put("Code", "ARS");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 10){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("AZN");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "Azerbaijanian - Manat");
                            exchange.put("Code", "AZN");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 11){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("BSD");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "Bahamian Dollar");
                            exchange.put("Code", "BSD");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 12){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("BAM");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "BOSNIA AND HERZEGOVINA - Convertible Mark");
                            exchange.put("Code", "BAM");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 13){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("BOB");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "BOLIVIA - Boliviano");
                            exchange.put("Code", "BOB");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 14){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("BND");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "BRUNEI DARUSSALAM - Brunei Dollar");
                            exchange.put("Code", "BND");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 15){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("CZK");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "CZECH REPUBLIC - Czech Koruna");
                            exchange.put("Code", "CZK");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 16){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("CAD");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "CANADA - Canadian Dollar");
                            exchange.put("Code", "CAD");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 17){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("COP");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "COLOMBIA - Colombian Peso");
                            exchange.put("Code", "COP");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 18){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("BIF");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "BURUNDI - Burundi Franc");
                            exchange.put("Code", "BIF");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }else if(i == 19){

                            // Getting JSON Array node
                            String Value = jsonObj.getString("VEF");

                            // tmp hash map for single exchange
                            HashMap<String, String> exchange = new HashMap<>();

                            exchange.put("Name", "VENEZUELA - Bolivar");
                            exchange.put("Code", "VEF");
                            exchange.put("Value", Value);


                            // adding exchange to exchange list
                            exchangeList.add(exchange);
                        }
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, exchangeList,
                    R.layout.list_item, new String[]{"Name", "Code",
                    "Value"}, new int[]{R.id.name,
                    R.id.email, R.id.mobile});

            lv.setAdapter(adapter);


        }

    }
}
