package com.mindnotix.kmk.activitys.watchlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.activitys.BaseActivity
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.ActivityWatchListBinding
import com.mindnotix.kmk.databinding.EpisodeDownloadListItemBinding
import com.mindnotix.kmk.databinding.WatchListItemBinding
import com.mindnotix.kmk.fragments.DownloadActionBottomFragment
import com.mindnotix.kmk.support.ToolbarSupport
import java.util.ArrayList

class WatchListActivity : BaseActivity() {
    private lateinit var binding: ActivityWatchListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_watch_list)
        initviews()
        WatchListSetup()
    }

    private fun initviews() {
        ToolbarSupport(getString(R.string.watch_list), binding.toolbar, this)
    }

    private fun WatchListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        RvWatchListAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvWatchListAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.watch_list_item)
        binding.RvWatchList.layoutManager = GridLayoutManager(
            this,
            2
        )
        binding.RvWatchList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: WatchListItemBinding =
                viewDataBinding as WatchListItemBinding

        }
    }
}