package com.henmory.test.glidetest;

/**
 * author: henmory
 * time:  4/11/18
 * function:
 * description:
 */
public class Bean {

    private String url;
    private int mode;//非常重要，在传入数据的时候，传入模式，进而可以根据不同的mode加载不同的布局

    public Bean(String url, int mode) {
        this.url = url;
        this.mode = mode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
