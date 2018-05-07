package com.rocky.web;

/**
 * Created by rocky on 18/5/7.
 */
public class StringHolder {
    private String s;

    public StringHolder(String s) {
        this.s = s;
    }

    public StringHolder() {
    }

    //    public StringHolder() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 100000000; i++) {
//            sb.append("a");
//        }
//        this.s = sb.toString();
//    }


    public String getS() {
        return s;
    }
}
