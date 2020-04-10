package cn.iwenchaos.newsapp.module.welcome.listener

import android.animation.Animator

/**
 * Created by:  awen on 2020/4/10  11:54 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */
interface LocalAnimatorListener :Animator.AnimatorListener{
    override fun onAnimationRepeat(animation: Animator?) {

    }

    override fun onAnimationEnd(animation: Animator?) {
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }
}