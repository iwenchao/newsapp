package cn.iwenchaos.newsapp.module.welcome

import android.Manifest
import android.animation.Animator
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import cn.iwenchaos.newsapp.R
import cn.iwenchaos.newsapp.base.BaseNewsActivity
import cn.iwenchaos.newsapp.databinding.ActivitySplashBinding
import cn.iwenchaos.newsapp.module.welcome.listener.LocalAnimatorListener
import cn.iwenchaos.newsapp.util.Router
import cn.iwenchaos.newsapp.util.permission.PermissionUtil
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by:  awen on 2020/4/9  9:28 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :  欢迎页
 */
class SplashActivity : BaseNewsActivity<ActivitySplashBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun beforeOnCreate(savedInstanceState: Bundle?) {
        super.beforeOnCreate(savedInstanceState)
        val lacks = PermissionUtil.checkPermissions(this, BASE_PERMISSIONS)
        lacks.takeIf { lacks.isNotEmpty() }.run {
            PermissionUtil.requestPermissions(this@SplashActivity, lacks.toTypedArray())
        }

    }

    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle?) {
        super.afterBindView(rootView, onSaveInstanceBundle)
        toMainAfterAnimator()
    }

    private fun toMainAfterAnimator() {
        lavAnimation.run {
            this.playAnimation()
            this.addAnimatorListener(object : LocalAnimatorListener {
                override fun onAnimationEnd(animation: Animator?) {
                    lavAnimation.clearAnimation()
                    Router.toMain(this@SplashActivity)
                    finish()
                }
            })
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(PermissionUtil.PERMISSION_REQUEST_CODE == requestCode){
            val denies = mutableListOf<String>()
            for(index in grantResults.indices){
                if(grantResults[index]== PackageManager.PERMISSION_DENIED){
                    denies.add(permissions[index])
                }
            }
            denies.isNotEmpty().run {

            }
        }
    }

    companion object {
        val BASE_PERMISSIONS = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE
        )
    }


}