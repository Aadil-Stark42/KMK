package com.mindnotix.kmk.activitys

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.ActivityDownloadBinding
import com.mindnotix.kmk.databinding.DownloadsListItemBinding
import com.mindnotix.kmk.databinding.EpisodeDownloadListItemBinding
import com.mindnotix.kmk.fragments.DownloadActionBottomFragment
import com.mindnotix.kmk.support.ToolbarSupport
import java.util.ArrayList

class DownloadActivity : BaseActivity() {
    private lateinit var binding: ActivityDownloadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_download)
        initviews()
        DownloadListSetup()
        EpisodeDownloadListSetup()
        ClickEvents()
    }

    private fun ClickEvents() {

    }

    private fun initviews() {
        ToolbarSupport(getString(R.string.downloads), binding.toolbar, this)
    }

    private fun DownloadListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.squad_game)
        list.add(R.drawable.top_result_1)
        list.add(R.drawable.more_result_1)
        RvDownloadAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvDownloadAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.downloads_list_item)
        binding.RvDownloadList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RvDownloadList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: DownloadsListItemBinding = viewDataBinding as DownloadsListItemBinding
            binding.imgDOwnloadThub.setImageResource(data[position])
            binding.root.setOnClickListener {
                if (position == 0) {
                    this.binding.RvDownloadList.visibility = View.GONE
                    this.binding.RvEpisodeDownloadList.visibility = View.VISIBLE
                }
            }
            if (position == 1) {
                binding.imgNext.visibility = View.GONE
                binding.rltvtrans.visibility = View.GONE
                binding.imgDot.visibility = View.GONE
                binding.txtSize.visibility = View.GONE
                binding.imgDelete.visibility = View.VISIBLE
                binding.txtEpisodeName.text = "453 mb"
            }
            if (position == 2) {
                binding.rltvtrans.visibility = View.VISIBLE
                binding.imgNext.visibility = View.GONE
                binding.imgDelete.visibility = View.GONE
                binding.imgDot.visibility = View.GONE
                binding.txtSize.visibility = View.GONE
                binding.txtEpisodeName.text = "720 mb"
            }
        }
    }

    private fun EpisodeDownloadListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.squad_game)

        RvDownloadEpisodeAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvDownloadEpisodeAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.episode_download_list_item)
        binding.RvEpisodeDownloadList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RvEpisodeDownloadList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: EpisodeDownloadListItemBinding =
                viewDataBinding as EpisodeDownloadListItemBinding
            binding.imgDownloadEpisode.setImageResource(data[position])
            binding.imgMenu.setOnClickListener {
                DownloadActionBottomFragment().show(supportFragmentManager, "TAG")
            }
        }
    }

    override fun onBackPressed() {
        if (binding.RvDownloadList.visibility == View.GONE) {
            binding.RvDownloadList.visibility = View.VISIBLE
            binding.RvEpisodeDownloadList.visibility = View.GONE
        } else {
            super.onBackPressed()
        }
    }
}