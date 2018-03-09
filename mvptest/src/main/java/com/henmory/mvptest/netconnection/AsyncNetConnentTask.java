package com.henmory.mvptest.netconnection;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * author: henmory
 * time:  11/23/16
 * function:
 * description:
 *
 */

public  abstract class AsyncNetConnentTask extends AsyncTask<Object,Object,Object> {
    private final static String tag = "AsyncNetConnentTask";

    private static boolean isConnecting = false;//网络正忙的标志


    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description    如果客户端是强制取消的，无论该函数执行到哪里，这个线程都会中断，并调用onCancelled
     *                  如果客户端不是强制的，如果取消在iscalled之前，那么不会继续网络连接
     *                  如果已经执行过，那么程序会继续下载，完成后调用oncalled
     *  @param
     *
     *
     *  @return
    */

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            if (isCancelled()){
                isConnecting = false;
                return null;
            }
            isConnecting = true;
            Object data;
            int size = params.length;
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < size; i++){
                strings.add((String)params[i]);
            }
            Log.e(tag, strings.toString());

            //parse http methord
            String httpMethord = (String) params[0];
            if (httpMethord.equals(HttpMethord.POST)){
                data = OkHttpUtil.post((String[]) params); //开始下载
            }else if(httpMethord.equals(HttpMethord.DELETE)){
                data = OkHttpUtil.delete((String[]) params); //开始下载
            }else{
                data = OkHttpUtil.get((String[]) params); //开始下载
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null; //OkHttpUtil异常返回null
        }
    }

    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description    this is called by main thread
     *                  客户端只有发生取消操作都不会执行
     *                  oncalled的优先级要高于自己
     *
     *  @param
     *
     *  @return
    */
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        isConnecting = false;
        if (null == o){//出现异常
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(ServerConfig.KEY_ERROR_CODE, ServerConfig.OKHTTP_ERROR_CODE);
                jsonObject.put(ServerConfig.KEY_ERROR_DESCRIPTION, ServerConfig.OKHTTTP_FAILED);
                taskOnFail(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            taskOnFail("出现异常...");
        }else{//网络请求成功
            try {
                JSONObject jsonObject = new JSONObject((String) o);//string  to json
                taskOnSuccess(jsonObject);//返回json格式数据

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(tag, "string转json失败");
//                taskOnFail("string转json失败");
                //when we get image, we cann't transform them to json, so when it throws exception,
                //we judge wheather is a image, if it's,  we throw the name of image  to activity

            }
        }
    }

    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description    只要发生取消操作就行执行
     *
     *  @param
     *
     *  @return
    */
    @Override
    protected void onCancelled() {//用户在连接过程中取消了,不返回任何数据
        super.onCancelled();
        isConnecting = false;
        Log.d(tag,"onCancelled");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(ServerConfig.KEY_ERROR_CODE, ServerConfig.USER_CANCLE_NET_REQUEST_ERROR_CODE);
            jsonObject.put(ServerConfig.KEY_ERROR_DESCRIPTION, ServerConfig.USER_CANCLE_NET_REQUEST);
            taskOnFail(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        taskOnFail("CANCEL"); //通知NetConnection重置网络连接标志位
    }

    public abstract void  taskOnSuccess(Object data);
    public abstract void taskOnFail(Object data);
}
