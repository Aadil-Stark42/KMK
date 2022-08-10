package com.mindnotix.kmk.activitys.moviedetails

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.activitys.BaseActivity
import com.mindnotix.kmk.activitys.subscribe.SubScribeContentActivity
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.*
import java.util.ArrayList

class MovieDetailsActivity : BaseActivity() {
    lateinit var binding: ActivityMovieDetailsBinding
    val listbool: ArrayList<Boolean> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        initviews()
        MoreLikeListSetup()
        TrailerListSetup()
        SeasonListSetup()
        EpisodeListSetup()
        ClickEvents()
    }

    private fun ClickEvents() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
        binding.imgWatchlist.setOnClickListener {
            binding.imgWatchlist.setImageResource(R.drawable.ic_watch_list_fill)
        }
        binding.imgWatchNow.setOnClickListener {
            startActivity(Intent(this, MoviePlayActivity::class.java))
            overridePendingTransition(0, R.anim.fade)

        }
        binding.llTrailerClick.setOnClickListener {
            binding.infoLine.visibility = View.GONE
            binding.llInfo.visibility = View.GONE
            binding.EpisodeLine.visibility = View.GONE
            binding.llEpisode.visibility = View.GONE

            binding.trailerLine.visibility = View.VISIBLE
            binding.llTrailer.visibility = View.VISIBLE


            binding.txtInfo.setTextColor(resources.getColor(R.color.view_grey2))
            binding.txtEpisode.setTextColor(resources.getColor(R.color.view_grey2))
            binding.txtTrailer.setTextColor(resources.getColor(R.color.view_white))

        }
        binding.llInfoClick.setOnClickListener {

            binding.trailerLine.visibility = View.GONE
            binding.llTrailer.visibility = View.GONE
            binding.EpisodeLine.visibility = View.GONE
            binding.llEpisode.visibility = View.GONE

            binding.infoLine.visibility = View.VISIBLE
            binding.llInfo.visibility = View.VISIBLE

            binding.txtInfo.setTextColor(resources.getColor(R.color.view_white))
            binding.txtEpisode.setTextColor(resources.getColor(R.color.view_grey2))

            binding.txtTrailer.setTextColor(resources.getColor(R.color.view_grey2))

        }
        binding.llEpisodeClick.setOnClickListener {

            binding.trailerLine.visibility = View.GONE
            binding.llTrailer.visibility = View.GONE
            binding.infoLine.visibility = View.GONE
            binding.llInfo.visibility = View.GONE

            binding.EpisodeLine.visibility = View.VISIBLE
            binding.llEpisode.visibility = View.VISIBLE

            binding.txtEpisode.setTextColor(resources.getColor(R.color.view_white))
            binding.txtInfo.setTextColor(resources.getColor(R.color.view_grey2))
            binding.txtTrailer.setTextColor(resources.getColor(R.color.view_grey2))

        }
    }

    private fun initviews() {
        listbool.add(true)
        listbool.add(false)
        window.statusBarColor = ContextCompat.getColor(this, R.color.view_black)
        binding.txtDirectorName.paintFlags =
            binding.txtDirectorName.paintFlags or Paint.UNDERLINE_TEXT_FLAG

    }


    private fun MoreLikeListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.slider_2)
        list.add(R.drawable.top_result_1)
        list.add(R.drawable.more_result_1)
        list.add(R.drawable.more_result_3)
        list.add(R.drawable.more_result_4)
        list.add(R.drawable.recent_1)
        list.add(R.drawable.recent_2)
        list.add(R.drawable.recent_3)
        RvMoreLikeAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvMoreLikeAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.most_like_list_item)
        binding.RvMoreLikeThis.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.RvMoreLikeThis.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: MostLikeListItemBinding = viewDataBinding as MostLikeListItemBinding
            binding.imgMoreLike.setImageResource(data[position])
        }
    }

    private fun TrailerListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.slider_2)
        list.add(R.drawable.top_result_1)
        list.add(R.drawable.more_result_1)
        list.add(R.drawable.more_result_3)
        list.add(R.drawable.more_result_4)
        list.add(R.drawable.recent_1)
        list.add(R.drawable.recent_2)
        list.add(R.drawable.recent_3)
        RvTrailerAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvTrailerAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.trailer_list_item)
        binding.RvTrailers.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RvTrailers.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: TrailerListItemBinding = viewDataBinding as TrailerListItemBinding
            binding.imgTrailer.setImageResource(data[position])
        }
    }

    private fun SeasonListSetup() {
        val list: ArrayList<String> = ArrayList()
        list.add("Season 1")
        list.add("Season 2")
        RvSeasonAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvSeasonAdapter(data: ArrayList<String>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.season_list_item)
        binding.RvSeasonList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.RvSeasonList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: SeasonListItemBinding = viewDataBinding as SeasonListItemBinding
            binding.txtSeason.text = data[position]
            if (listbool[position]) {
                binding.txtSeason.setBackgroundResource(R.drawable.season_tab)
                binding.txtSeason.setTextColor(resources.getColor(R.color.view_white))
            } else {
                binding.txtSeason.setTextColor(resources.getColor(R.color.view_grey2))
                binding.txtSeason.setBackgroundResource(0)
            }
            binding.txtSeason.setOnClickListener {
                for (i in 0 until listbool.size) {
                    listbool[i] = false
                }
                listbool[position] = true
                SeasonListSetup()
            }
        }
    }

    private fun EpisodeListSetup() {
        val list: ArrayList<String> = ArrayList()
        list.add(" ")
        list.add(" ")
        list.add(" ")
        list.add(" ")
        list.add(" ")
        list.add(" ")
        RvEpisodeAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvEpisodeAdapter(data: ArrayList<String>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.episode_list_item)
        binding.RvEpisodeList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RvEpisodeList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: EpisodeListItemBinding = viewDataBinding as EpisodeListItemBinding
            binding.imgDownload.setOnClickListener {
                binding.downloadProgress.visibility = View.VISIBLE
                var ProgressCount = 1
                val handler = Handler()
                val r: Runnable = object : Runnable {
                    @SuppressLint("UseCompatLoadingForColorStateLists")
                    override fun run() {
                        binding.downloadProgress.progress = ProgressCount
                        if (ProgressCount == 100) {
                            binding.downloadProgress.visibility = View.INVISIBLE
                            binding.imgDownload.visibility = View.GONE
                            binding.imgCheck.visibility = View.VISIBLE
                            handler.removeCallbacks(this)
                        } else {
                            ProgressCount += 1
                            handler.postDelayed(this, 100)
                        }

                    }
                }
                handler.postDelayed(r, 100)
            }

        }
    }
}