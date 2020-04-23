package cn.iwenchaos.newsapp.util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import java.util.*

/**
 * Created by:  awen on 2020/4/11  3:37 PM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */
object ActivityHelper {

    @Volatile
    private var inited = false

    private val frontActivityStack = Stack<Activity>()

    private val runningActivityStack = Stack<Activity>()

    private val onAppStateChangeListeners = mutableListOf<OnAppStateChangedListener>();


    @JvmStatic fun init(context: Context) {
        if (!inited) {
            synchronized(this) {
                if (!inited) {
                    val application = context.applicationContext as Application
                    application.registerActivityLifecycleCallbacks(ActivityLifeCircleCallback())
                }
            }

        }

    }


    private class ActivityLifeCircleCallback : Application.ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            if (!frontActivityStack.contains(activity)) {
                frontActivityStack.add(activity)
            }
        }

        override fun onActivityStarted(activity: Activity) {

        }

        override fun onActivityResumed(activity: Activity) {
            if (runningActivityStack.contains(activity)) {
                runningActivityStack.add(activity)
            }
        }

        override fun onActivityPaused(activity: Activity) {
            if (runningActivityStack.contains(activity)) {
                runningActivityStack.remove(activity)
            }
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivityDestroyed(activity: Activity) {
            if (frontActivityStack.contains(activity)) {
                frontActivityStack.add(activity)
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

    }

    interface OnAppStateChangedListener {
        fun onAppToBack(topActivity: Activity)
        fun onAppToFront(topActivity: Activity)
    }


}