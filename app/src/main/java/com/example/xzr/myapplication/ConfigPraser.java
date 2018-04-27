package com.example.xzr.myapplication;

import android.util.Log;
import android.util.Xml;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


public class ConfigPraser {
    public static final String TAG = "ConfigPraser";
    public static final String APP = "app";
    public static final String RULE = "rule";
    public static final String ACT = "action";

    private ConfigItem item = null;
    private ConfigAttr rule = null;
    private ConfigAttr action = null;


    ConfigPraser(InputStream is) throws Exception {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is, "utf-8");

        int type = parser.getEventType();
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                //开始标签
                case XmlPullParser.START_TAG:
                    if (APP.equals(parser.getName())) {
                        if (null == item) {
                            item = new ConfigItem();
                        }
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            item.addAttr(parser.getAttributeName(i), parser.getAttributeValue(i));
                        }
                        break;
                    }
                    if (RULE.equals(parser.getName())) {
                        if (null == rule) {
                            rule = new ConfigAttr();
                        }
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            rule.put(parser.getAttributeName(i), parser.getAttributeValue(i));
                        }
                        break;
                    }
                    if (ACT.equals(parser.getName())) {
                        if (null == action) {
                            action = new ConfigAttr();
                        }
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            action.put(parser.getAttributeName(i), parser.getAttributeValue(i));
                        }
                        break;
                    }
                case XmlPullParser.END_TAG:
                    if (ACT.equals(parser.getName())) {
                        break;
                    }
                    if (RULE.equals(parser.getName())) {
                        if (null != item) {
                            item.addRule(rule, action);
                        }
                        rule = action = null;
                        break;
                    }
                    if (APP.equals(parser.getName())) {
                        if (null != item) {
                            item.print();
                        }
                        item = null;
                        break;
                    }
            }
            //继续往下读取标签类型
            type = parser.next();
        }
    }

}