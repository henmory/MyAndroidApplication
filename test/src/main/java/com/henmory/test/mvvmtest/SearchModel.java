package com.henmory.test.mvvmtest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public class SearchModel implements ISearchModel {

    @Override
    public void getIPaddressInfo(final String ipAddress, final onSearchListener onSearchListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String apiUrl = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=Json&ip=";
                try {
                    MyIP myIP = new MyIP();
                    URL url = new URL(apiUrl + ipAddress);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("GET");

                    InputStreamReader isp = new InputStreamReader(httpURLConnection.getInputStream());
                    BufferedReader bf = new BufferedReader(isp);
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bf.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }

                    JSONObject jsonObject = new JSONObject(String.valueOf(stringBuilder));

                    myIP.setCountry(jsonObject.getString("country"));
                    myIP.setProvince(jsonObject.getString("province"));
                    myIP.setCity(jsonObject.getString("city"));
                    onSearchListener.onSuccess(myIP);
                } catch (IOException | JSONException e) {
                    onSearchListener.onError();
                }
            }
        }).start();

    }
}
