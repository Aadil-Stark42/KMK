package com.mindnotix.kmk.activitys.preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mindnotix.kmk.R
import com.mindnotix.kmk.activitys.BaseActivity
import com.mindnotix.kmk.databinding.ActivityPreferenceBinding
import com.mindnotix.kmk.fragments.DownloadActionBottomFragment
import com.mindnotix.kmk.fragments.VideoQualityFragment
import com.mindnotix.kmk.support.ToolbarSupport

class PreferenceActivity : BaseActivity() {
    private lateinit var binding: ActivityPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_preference)
        initviews()
        CLickEvents()
    }

    private fun CLickEvents() {
        binding.llVideoQuality.setOnClickListener {
            VideoQualityFragment().show(supportFragmentManager, "TAG")
        }
    }

    private fun initviews() {
        ToolbarSupport(getString(R.string.preference), binding.toolbar, this)
    }
}