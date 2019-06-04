package com.wy.core.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.wy.core.BaseApplicationProxy;


/**
 * [SharedPreferences基础配置操作类]<br/>
 */
public abstract class BasePreference {

    protected BasePreference() {
        init(BaseApplicationProxy.getApplicationContext());
    }

    private SharedPreferences preferences;

    public boolean contains(String key) {
        if (preferences == null) {
            return false;
        }
        if (key == null) {
            return false;
        }
        return preferences.contains(key);
    }

    public void removeAll() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    public boolean setValue(String key, String value) {
        if (preferences == null) {
            return false;
        }
        if (key == null) {
            return false;
        }
        return preferences.edit().putString(key, value).commit();
    }

    public boolean setValue(String key, int value) {
        if (preferences == null) {
            return false;
        }

        if (key == null) {
            return false;
        }

        return preferences.edit().putInt(key, value).commit();
    }

    public boolean setValue(String key, boolean value) {
        if (preferences == null) {
            return false;
        }

        if (key == null) {
            return false;
        }

        return preferences.edit().putBoolean(key, value).commit();
    }


    public boolean setValue(String key, long value) {
        if (preferences == null) {
            return false;
        }

        if (key == null) {
            return false;
        }

        return preferences.edit().putLong(key, value).commit();
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        if (preferences == null) {
            return 0;
        }

        if (key == null) {
            return 0;
        }
        return preferences.getInt(key, defaultValue);
    }

    public String getString(String key, String def) {
        if (preferences == null) {
            return def;
        }

        if (key == null) {
            return def;
        }

        return preferences.getString(key, def);
    }

    public boolean getBoolean(String key) {
        if (preferences == null) {
            return false;
        }

        if (key == null) {
            return false;
        }

        return preferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        if (preferences == null) {
            return false;
        }
        if (key == null) {
            return false;
        }

        return preferences.getBoolean(key, defaultValue);
    }


    public long getLong(String key) {
        if (preferences == null) {
            return 0;
        }

        if (key == null) {
            return 0;
        }

        return preferences.getLong(key, 0L);
    }

    public long getLong(String key, long defValue) {
        if (preferences == null) {
            return 0;
        }

        if (key == null) {
            return 0;
        }

        return preferences.getLong(key, defValue);
    }


    public void init(Context context) {
        preferences = context.getSharedPreferences(getPreferenceName(), 0);
    }

    public void release() {
        preferences = null;
    }


    protected abstract String getPreferenceName();

}
