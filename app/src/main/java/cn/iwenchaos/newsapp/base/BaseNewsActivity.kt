package cn.iwenchaos.newsapp.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

/**
 * Created by:  awen on 2020/4/9  10:50 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :  业务基类
 */
abstract class BaseNewsActivity<B : ViewDataBinding> : BaseViewActivity() {

    private lateinit var viewModelProvider: ViewModelProvider

    private lateinit var viewDataBinding: B


    override fun onCreate(savedInstanceState: Bundle?) {
        beforeBindView()
        super.onCreate(savedInstanceState)
        bindView(rootView)
        afterBindView(rootView, savedInstanceState)

    }

    override fun beforeBindView() {
        Log.i(TAG, "javaClass=$TAG")
    }


    override fun bindView(rootView: View?) {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }


    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle?) {

    }


    companion object {
        val TAG = BaseNewsActivity::class.java.simpleName
    }


}