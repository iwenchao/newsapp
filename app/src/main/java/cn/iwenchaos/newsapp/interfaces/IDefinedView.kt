package cn.iwenchaos.newsapp.interfaces

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes

/**
 * Created by:  awen on 2020/4/9  9:55 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */

interface IDefinedView {

    /**
     * 获取布局文件资源id
     */
    @LayoutRes
    fun getLayoutId(): Int

    fun beforeBindView()
    fun bindView(rootView: View?)
    fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle)

}