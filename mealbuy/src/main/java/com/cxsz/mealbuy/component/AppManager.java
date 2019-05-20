package com.cxsz.mealbuy.component;

import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 15157_000 on 2016/6/3 0003.
 */
public class AppManager {

    private AppManager() {

    }
    private static AppManager instance = new AppManager();
    private static List<AppCompatActivity> activityStack = new LinkedList<>();


    public static AppManager getInstance() {
        return instance;
    }

    public void addActivity(AppCompatActivity aty) {
        activityStack.add(aty);
    }

    public void removeActivity(AppCompatActivity aty) {
        activityStack.remove(aty);
    }


    /**
     * 结束所有的Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
}
