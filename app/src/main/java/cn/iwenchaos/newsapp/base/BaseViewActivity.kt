package cn.iwenchaos.newsapp.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.iwenchaos.newsapp.interfaces.IAboveView
import cn.iwenchaos.newsapp.interfaces.IDefinedView

/**
 * Created by:  awen on 2020/4/8  5:56 PM
 * email     :  liuwenchao@mockuai.com
 * Describe  :  视图基类
 */

abstract class BaseViewActivity : AppCompatActivity(), IDefinedView, IAboveView {

    protected var rootView: View? = null;


    open fun beforeOnCreate(savedInstanceState: Bundle?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeOnCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        rootView = window.decorView.rootView
        afterOnCreate(savedInstanceState)
    }

    open fun afterOnCreate(savedInstanceState: Bundle?) {

    }

    override fun showLoading(msg: String?) {

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    companion object {
        val TAG = BaseViewActivity::class.java.simpleName
    }

}