package ca.doophie.stripessuck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatImageView
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    private var isRunning = true
    private lateinit var stripeHolder: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stripeHolder = findViewById(R.id.stipeHolder)

        doAStripe()
        doAStripe()
    }

    private fun doAStripe() {
        if (!isRunning) return

        val stripe = makeStripe()

        stripeHolder.addView(stripe)

        stripe.animation.onAnimationEnd {
            (stripe.parent as ViewGroup).removeView(stripe)

            doAStripe()
        }

        stripe.animate()
    }

    private fun makeStripe(): AppCompatImageView {
        val imageView = AppCompatImageView(applicationContext)

        imageView.layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        imageView.setImageResource(listOf(R.drawable.cp_stripe_blue, R.drawable.cp_stripe_gray, R.drawable.cp_stripe_red).random())

        imageView.clearAnimation()

        imageView.animation = AnimationUtils.loadAnimation(applicationContext, listOf(R.anim.left_to_right, R.anim.left_to_right_fast, R.anim.left_to_right_slow).random())

        imageView.x = stripeHolder.width / 2f
        imageView.y = (0..(stripeHolder.height)).random().toFloat()

        return imageView
    }


}
