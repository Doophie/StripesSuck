package ca.doophie.stripessuck

import android.view.animation.Animation

fun Animation.onAnimationEnd(callback: () -> Unit) {
    setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {
        }

        override fun onAnimationEnd(p0: Animation?) {
            callback()
        }

        override fun onAnimationStart(p0: Animation?) {
        }

    })
}