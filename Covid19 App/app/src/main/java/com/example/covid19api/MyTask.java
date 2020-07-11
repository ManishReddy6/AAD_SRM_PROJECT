package com.example.covid19api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void,Void,String> {
    String url="https://api.covid19api.com/dayone/country/IN";
    Context ct;
    RecyclerView myRv;
    ProgressDialog pd;

    public MyTask(MainActivity mainActivity, RecyclerView rv) {
        ct=mainActivity;
        myRv=rv;
    }


    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u = new URL(url);
            HttpsURLConnection connection =(HttpsURLConnection)u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while ((line=reader.readLine())!=null){
                builder.append(line);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ct);
        pd.setMessage("Please Wait....");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        List<Covid> covidList = new ArrayList<>();
        try {
            JSONArray rootJSONArray=new JSONArray(s);
            for(int i=rootJSONArray.length()-1;i>=0;i--)
            {
                JSONObject indexObject=rootJSONArray.getJSONObject(i);
                String date=indexObject.optString("Date");
                String active=indexObject.optString("Active");
                String recovered=indexObject.optString("Recovered");
                String death=indexObject.optString("Deaths");
                Covid c=new Covid(date,active,recovered,death);
                covidList.add(c);
            }
            Log.i("SIZE",""+covidList.size());
            myRv.setLayoutManager(new LinearLayoutManager(ct));
            myRv.setAdapter(new CovidAdapter(ct,covidList));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}