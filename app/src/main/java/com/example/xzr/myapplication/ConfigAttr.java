package com.example.xzr.myapplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigAttr {
    private HashMap<String, String> attrMap;
    private ConfigAttr attr = null;

    ConfigAttr() {
        attrMap = new HashMap<String, String>();
    }

    public void put(String k, String v) {
        attrMap.put(k, v);
    }

    public String get(String k) {
        return attrMap.get(k);
    }

    public int size() {
        return attrMap.size();
    }

    public Set<Map.Entry<String,String>> entrySet(){
        return attrMap.entrySet();
    }

    public String toString() {
        return attrMap.toString();
    }

}
