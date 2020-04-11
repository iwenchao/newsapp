package cn.iwenchaos.newsapp.module.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import cn.iwenchaos.newsapp.R
import cn.iwenchaos.newsapp.base.BaseNewsActivity
import cn.iwenchaos.newsapp.databinding.ActivityMainBinding

class MainActivity : BaseNewsActivity<ActivityMainBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle?) {
        super.afterBindView(rootView, onSaveInstanceBundle)

    }

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
