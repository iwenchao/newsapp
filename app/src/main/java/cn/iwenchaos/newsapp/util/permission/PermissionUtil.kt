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

        private const val PERMISSION_REQUEST_CODE = 100;

        val BASE_PERMISSIONS = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET
        )

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

        fun requestPermissions(activity: Context, permissions: Array<String>) {
            if (activity is Activity) {
                ActivityCompat.requestPermissions(activity, permissions, PERMISSION_REQUEST_CODE)
            }
        }

    }
}