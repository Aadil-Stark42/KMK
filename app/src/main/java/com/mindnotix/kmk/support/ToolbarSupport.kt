package com.mindnotix.kmk.support

import android.app.Activity
import com.mindnotix.kmk.databinding.ToolbarIncludedBinding

class ToolbarSupport(
    title: String,
    toolbar: ToolbarIncludedBinding,
    activity: Activity
) {

    init {
        toolbar.imgBack.setOnClickListener {
            activity.onBackPressed()
        }
        toolbar.txtTitle.text = title
    }
}