package com.henmory.test.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public class HandlerEvent {
    private Context context;
    public HandlerEvent(Context context){
        this.context = context;
    }
    public void onClickFriend(View view){
        Toast.makeText(context, "onClickFriend", Toast.LENGTH_LONG).show();
    }
}
