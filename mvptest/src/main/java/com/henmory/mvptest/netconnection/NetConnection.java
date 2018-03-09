package com.henmory.mvptest.netconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * author: henmory
 * time:  11/23/16
 * function:
 * description:该文件主要查看网络通信是否正常
 *              taskOnSuccess：代表网络通信成功
 *              taskOnFail:代表网络通信失败
 *              操作成功：返回服务器给的数据内容，由上一层业务处理
 *              操作失败：返回所有错误码和描述，这里的错误都是由于网络或者用户操作引起的
 *              1.OKhttp失败
 *              2.用户取消
 *              3.服务器返回的数据不能转换成json
 *              4.网络繁忙
 */

public abstract class NetConnection {
    private final static String tag = "NetConnection";

    private static AsyncNetConnentTask task = null;
    public static AsyncNetConnentTask getTask() {
        return task;
    }

    //param = http_methord[0] + action[1] + token[key,value] + [key,value]

    public  NetConnection(Context context, String... param){

        //检测网络是否正在使用
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        //没有网络或者网络连接忙
        if (info == null ||  !info.isConnected()){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(ServerConfig.KEY_ERROR_CODE, ServerConfig.NET_BUSY_ERROR_CODE);
                jsonObject.put(ServerConfig.KEY_ERROR_DESCRIPTION, ServerConfig.NET_BUSY);
                netConnectionFail(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            netConnectionFail("net error");
            return;
        }

        task = new AsyncNetConnentTask() {
            @Override
            public void taskOnSuccess(Object data) {
                Log.d(tag, "NetConnection: " + data.toString());
                task = null;
                netConnectionSuccess(data);//不做任何处理
            }

            @Override
            public void taskOnFail(Object data) {
                Log.d(tag, "NetConnection: " + data.toString());
                task = null;
                netConnectionFail(data);
            }
        };
        task.execute(param);


    }

    //通信完成，保证肯定是json数据，而且肯定是正常的数据，但是不一定保证用户的操作是正确的，但是操作流程是正确的
    public abstract void netConnectionSuccess(Object data);
    public abstract void netConnectionFail(Object data);//通信失败



}
