package cn.iwenchaos.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.iwenchaos.newsapp.base.BaseNewsActivity

class MainActivity : BaseNewsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun getLayoutId(): Int = 0
}
