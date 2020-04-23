package cn.iwenchaos.newsapp.util.permission

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

/**
 * Created by:  awen on 2020/4/10  5:43 PM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */

class PermissionUtil {

    companion object {

        const val PERMISSION_REQUEST_CODE = 100;


        @JvmStatic
        fun checkPermissions(context: Context, permissions: Array<String>): List<String> {
            val lackPermissions = arrayListOf<String>()
            permissions.forEach {
                if ((ActivityCompat.checkSelfPermission(
                        context,
                        it
                    ) != PackageManager.PERMISSION_GRANTED)
                ) {
                    lackPermissions.add(it)
                }
            }

            return lackPermissions
        }

        fun requestPermissions(activity: Context, permissions: Array<String>, requestCode: Int = PERMISSION_REQUEST_CODE) {
            if (activity is Activity) {
                ActivityCompat.requestPermissions(activity, permissions, requestCode)
            }
        }

    }
}