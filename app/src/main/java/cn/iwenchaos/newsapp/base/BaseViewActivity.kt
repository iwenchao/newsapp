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



    override fun beforeBindView() {
        Log.i(TAG, "javaClass=$TAG")
    }

    protected fun beforeOnCreate(savedInstanceState: Bundle?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeOnCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        afterOnCreate(savedInstanceState)
    }

    protected fun afterOnCreate(savedInstanceState: Bundle?) {

    }

    override fun bindView(rootView: View?) {
    }


    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle) {

    }

    override fun showLoading(msg: String?) {

    }


    companion object {
        val TAG = BaseViewActivity::class.java.simpleName
    }

}