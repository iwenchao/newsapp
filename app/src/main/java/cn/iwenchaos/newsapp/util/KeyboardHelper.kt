package cn.iwenchaos.newsapp.util

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.lang.reflect.Field

/**
 * Created by:  awen on 2020/4/11  3:31 PM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */
object KeyboardHelper {
    /**
     * 打开软键盘
     * @param editText
     * 输入框
     */
    @JvmStatic
    fun show(editText: EditText?) {
        val imm = (editText?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?: return
        imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * 关闭软键盘
     * @param editText
     * 输入框
     */
    @JvmStatic
    fun hide(editText: EditText?) {
        val imm = editText?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    @JvmStatic
    fun hide(activity: Activity?) {
        val inputMethodManager = (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?: return
        if (inputMethodManager.isActive && activity.currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        }
    }


    /**
     * 通过反射清空内存泄漏
     * @param destContext
     */
    @JvmStatic
    fun fixInputMethodManagerLeak(destContext: Context?) {
        if (destContext == null) {
            return
        }
        val inputMethodManager = (destContext.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?: return

        val viewArray = arrayOf("mCurRootView", "mServedView", "mNextServedView", "mLastSrvView")
        var filed: Field?
        var filedObject: Any?
        for (view in viewArray) {
            try {
                filed = inputMethodManager.javaClass.getDeclaredField(view)
                if (filed == null) {
                    continue
                }
                if (!filed.isAccessible) {
                    filed.isAccessible = true
                }
                filedObject = filed.get(inputMethodManager)
                if (filedObject != null && filedObject is View) {
                    val fileView = filedObject as View?
                    if (fileView!!.context === destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        filed.set(inputMethodManager, null) // 置空，破坏掉path to gc节点
                    }
                }
            } catch (t: Throwable) {
            }

        }
    }
}