package cn.iwenchaos.newsapp.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

/**
 * Created by:  awen on 2020/4/9  10:50 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :  业务基类
 */
abstract class BaseNewsActivity<B : ViewDataBinding> : BaseViewActivity() {

    private lateinit var viewModelProvider:ViewModelProvider

    private lateinit var viewDataBinding: B





}