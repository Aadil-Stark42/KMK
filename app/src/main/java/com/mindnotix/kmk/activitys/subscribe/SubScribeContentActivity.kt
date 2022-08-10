package com.mindnotix.kmk.activitys.subscribe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.mindnotix.kmk.R
import com.mindnotix.kmk.databinding.ActivitySubScribeContentBinding
import com.mindnotix.kmk.view.GradientTextView
import com.mindnotix.kmk.view.blurimageview.BlurImage

class SubScribeContentActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubScribeContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_scribe_content)
        initviews()
        ClickEvents()
    }

    private fun ClickEvents() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
        binding.llBasic.setOnClickListener {
            RemoveClick()
            BasicClick()

            RemovePlan()
            BasicPlanClick()
        }
        binding.llStanderd.setOnClickListener {
            RemoveClick()
            StanderdClick()

            RemovePlan()
            StanderdPlanClick()
        }
        binding.llPremuim.setOnClickListener {
            RemoveClick()
            PremuimClick()

            RemovePlan()
            PremuimPlanClick()
        }


        binding.llBasicPlan.setOnClickListener {
            binding.llBasic.performClick()
            RemovePlan()
            BasicPlanClick()
        }
        binding.llStandrdPlan.setOnClickListener {
            binding.llStanderd.performClick()
            RemovePlan()
            StanderdPlanClick()
        }
        binding.llPremuimPlan.setOnClickListener {
            binding.llPremuim.performClick()
            RemovePlan()
            PremuimPlanClick()
        }
    }

    private fun BasicPlanClick() {
        binding.imgBasicPlanCheck.visibility = View.VISIBLE
        binding.llBasicPlan.setBackgroundResource(R.drawable.ic_plan_selected)
    }

    private fun StanderdPlanClick() {
        binding.imgStandrdPlanCheck.visibility = View.VISIBLE
        binding.llStandrdPlan.setBackgroundResource(R.drawable.ic_plan_selected)
    }

    private fun PremuimPlanClick() {
        binding.imgPremuimPlanCheck.visibility = View.VISIBLE
        binding.llPremuimPlan.setBackgroundResource(R.drawable.ic_plan_selected)
    }

    private fun RemovePlan() {
        binding.imgBasicPlanCheck.visibility = View.GONE
        binding.imgStandrdPlanCheck.visibility = View.GONE
        binding.imgPremuimPlanCheck.visibility = View.GONE

        binding.llBasicPlan.setBackgroundResource(R.drawable.ic_un_selected_plan)
        binding.llStandrdPlan.setBackgroundResource(R.drawable.ic_un_selected_plan)
        binding.llPremuimPlan.setBackgroundResource(R.drawable.ic_un_selected_plan)
    }

    private fun RemoveClick() {
        ChangeTintGrey(binding.imgNoBasiAllContent)
        ChangeTintGrey(binding.imgNoBasiDownload)
        ChangeTextGrey(binding.txtBasicMaxVideo)
        ChangeTextGrey(binding.txtBasicMaxAudio)
        binding.llBasic.setBackgroundResource(0)
        VisiblityView(binding.txtBasic, View.VISIBLE)
        VisiblityView(binding.txtBasicClick, View.GONE)


        ChangeTintGrey(binding.imgNoStanderdAllContent)
        ChangeTintGrey(binding.imgNoStanderdDownload)
        ChangeTextGrey(binding.txtStanderdMaxAudio)
        ChangeTextGrey(binding.txtStanderdMaxVideo)
        binding.llStanderd.setBackgroundResource(0)
        VisiblityView(binding.txtStandrd, View.VISIBLE)
        VisiblityView(binding.txtStandrdClick, View.GONE)

        ChangeTintGrey(binding.imgNoPremuimAllContent)
        ChangeTintGrey(binding.imgNoPremuimDownload)
        ChangeTextGrey(binding.txtPremuimMaxAudio)
        ChangeTextGrey(binding.txtPremuimMaxVideo)
        binding.llPremuim.setBackgroundResource(0)
        VisiblityView(binding.txtPremuim, View.VISIBLE)
        VisiblityView(binding.txtPremuimClick, View.GONE)
    }

    private fun VisiblityView(textview: GradientTextView, visiblity: Int) {
        textview.visibility = visiblity

    }

    private fun BasicClick() {
        ChangeTintWhite(binding.imgNoBasiAllContent)
        ChangeTintWhite(binding.imgNoBasiDownload)
        ChangeTextWhite(binding.txtBasicMaxVideo)
        ChangeTextWhite(binding.txtBasicMaxAudio)
        binding.llBasic.setBackgroundResource(R.drawable.season_tab)
        VisiblityView(binding.txtBasic, View.GONE)
        VisiblityView(binding.txtBasicClick, View.VISIBLE)
    }

    private fun StanderdClick() {
        ChangeTintWhite(binding.imgNoStanderdAllContent)
        ChangeTintWhite(binding.imgNoStanderdDownload)
        ChangeTextWhite(binding.txtStanderdMaxAudio)
        ChangeTextWhite(binding.txtStanderdMaxVideo)
        binding.llStanderd.setBackgroundResource(R.drawable.season_tab)
        VisiblityView(binding.txtStandrd, View.GONE)
        VisiblityView(binding.txtStandrdClick, View.VISIBLE)
    }

    private fun PremuimClick() {
        ChangeTintWhite(binding.imgNoPremuimAllContent)
        ChangeTintWhite(binding.imgNoPremuimDownload)
        ChangeTextWhite(binding.txtPremuimMaxAudio)
        ChangeTextWhite(binding.txtPremuimMaxVideo)
        binding.llPremuim.setBackgroundResource(R.drawable.season_tab)
        VisiblityView(binding.txtPremuim, View.GONE)
        VisiblityView(binding.txtPremuimClick, View.VISIBLE)
    }

    private fun ChangeTextWhite(textview: TextView) {
        textview.setTextColor(resources.getColor(R.color.view_white))
    }

    private fun ChangeTextGrey(textview: TextView) {
        textview.setTextColor(resources.getColor(R.color.view_grey2))
    }

    private fun ChangeTintWhite(imageview: ImageView) {
        imageview.setColorFilter(ContextCompat.getColor(this, R.color.view_white));

    }

    private fun ChangeTintGrey(imageview: ImageView) {
        imageview.setColorFilter(ContextCompat.getColor(this, R.color.view_grey2));
    }

    private fun initviews() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.view_black)
        BlurImage.with(applicationContext).load(R.drawable.squad_game).intensity(50F).Async(true)
            .into(binding.imgBlurview)

    }
}