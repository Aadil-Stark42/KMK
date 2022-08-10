package com.mindnotix.kmk.activitys.moviedetails

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.halilibo.bvpkotlin.BetterVideoPlayer
import com.halilibo.bvpkotlin.VideoCallback
import com.halilibo.bvpkotlin.captions.CaptionsView
import com.mindnotix.kmk.R
import com.mindnotix.kmk.databinding.ActivityMoviePlayBinding

class MoviePlayActivity : AppCompatActivity() {
    lateinit var bvp: BetterVideoPlayer
    private val mHideHandler = Handler()
    private val mHidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        bvp.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
    private val mShowPart2Runnable = Runnable {
        // Delayed display of UI elements
        val actionBar = supportActionBar
        actionBar?.show()
    }
    private var mVisible: Boolean = false
    private val mHideRunnable = Runnable { hide() }
    private lateinit var binding: ActivityMoviePlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_play)
        VideoSetup(savedInstanceState)
    }

    private fun VideoSetup(savedInstanceState: Bundle?) {
        bvp = binding.bvp

        if (savedInstanceState == null) {
            bvp.setAutoPlay(true)
            bvp.setSource(Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"))
         /*   bvp.setCaptions(R.raw.sub, CaptionsView.SubMime.SUBRIP)*/
        }

        bvp.setHideControlsOnPlay(true)

      /*  bvp.getToolbar().inflateMenu(R.menu.menu_dizi)*/
/*
        bvp.getToolbar().overflowIcon = ContextCompat.getDrawable(this, R.drawable.ic_settings_white_24dp)
*/
      /*  bvp.getToolbar().setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_enable_swipe -> bvp.enableSwipeGestures(window)
                R.id.action_enable_double_tap -> bvp.enableDoubleTapGestures(5000)
                R.id.action_disable_swipe -> bvp.disableGestures()
                R.id.action_show_bottombar -> bvp.setBottomProgressBarVisibility(true)
                R.id.action_hide_bottombar -> bvp.setBottomProgressBarVisibility(false)
                R.id.action_show_captions -> bvp.setCaptions(R.raw.sub, CaptionsView.SubMime.SUBRIP)
                R.id.action_hide_captions -> bvp.removeCaptions()
            }
            false
        }*/

        bvp.enableSwipeGestures(window)/*
        bvp.enableDoubleTapGestures(5000)*/
        bvp.setCallback(object : VideoCallback {
            override fun onStarted(player: BetterVideoPlayer) {
                Log.i(TAG, "Started")
            }

            override fun onPaused(player: BetterVideoPlayer) {
                Log.i(TAG, "Paused")
            }

            override fun onPreparing(player: BetterVideoPlayer) {
                Log.i(TAG, "Preparing")
            }

            override fun onPrepared(player: BetterVideoPlayer) {
                Log.i(TAG, "Prepared")
            }

            override fun onBuffering(percent: Int) {
                Log.i(TAG, "Buffering $percent")
            }

            override fun onError(player: BetterVideoPlayer, e: Exception) {
                Log.i(TAG, "Error " + e.message)
            }

            override fun onCompletion(player: BetterVideoPlayer) {
                Log.i(TAG, "Completed")
            }

            override fun onToggleControls(player: BetterVideoPlayer, isShowing: Boolean) {

            }
        })
    }

    companion object {
        const val TAG = "MainActivity"
        private val AUTO_HIDE = true

        /**
         * If [.AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private val UI_ANIMATION_DELAY = 300
    }

    public override fun onPause() {
        bvp.pause()
        super.onPause()
    }
    private fun hide() {
        // Hide UI first
        val actionBar = supportActionBar
        actionBar?.hide()
        mVisible = false

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable)
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY.toLong())
    }

    @SuppressLint("InlinedApi")
    private fun show() {
        // Show the system bar
        bvp.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        mVisible = true

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable)
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY.toLong())
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100)
    }

    private fun delayedHide(delayMillis: Int) {
        mHideHandler.removeCallbacks(mHideRunnable)
        mHideHandler.postDelayed(mHideRunnable, delayMillis.toLong())
    }

}