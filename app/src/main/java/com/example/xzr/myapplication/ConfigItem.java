package com.example.xzr.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigItem {
    private ConfigAttr attrMap;
    private List<ConfigAttr> ruleList;
    private List<ConfigAttr> actList;

    public ConfigItem() {
        attrMap = new ConfigAttr();
        ruleList = new ArrayList<ConfigAttr>();
        actList = new ArrayList<ConfigAttr>();
    }

    public void addAttr(String name, String value) {
        attrMap.put(name, value);
    }

    public void addRule(ConfigAttr rule, ConfigAttr action) {
        ruleList.add(rule);
        actList.add(action);
    }

    public void print() {
        Log.d("XX", "attr" + attrMap.toString());

        if (ruleList.size() != actList.size()) {
            Log.d("XX", "XXXXXXXXXXXXXXXXX");
        }
        for (int i = 0; i < ruleList.size(); i++) {
            Log.d("XX", "   ----------------------------");
            Log.d("XX", "   rule" + ruleList.get(i).toString());
            Log.d("XX", "   act" + actList.get(i).toString());
            Log.d("XX", "   ----------------------------");

        }
    }
}
