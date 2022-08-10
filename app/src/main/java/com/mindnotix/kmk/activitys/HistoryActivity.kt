package com.mindnotix.kmk.activitys

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.ActivityHistoryBinding
import com.mindnotix.kmk.databinding.EpisodeDownloadListItemBinding
import com.mindnotix.kmk.databinding.HistoryListItemBinding
import com.mindnotix.kmk.fragments.DownloadActionBottomFragment
import com.mindnotix.kmk.support.ToolbarSupport
import java.util.ArrayList

class HistoryActivity : BaseActivity() {
    private lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)
        initviews()
        HistoryListSetup()
    }

    private fun initviews() {
        ToolbarSupport(getString(R.string.history), binding.toolbar, this)
    }

    private fun HistoryListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)
        list.add(R.drawable.squad_game)

        RvHistoryAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvHistoryAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.history_list_item)
        binding.RvHistoryList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RvHistoryList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: HistoryListItemBinding =
                viewDataBinding as HistoryListItemBinding

        }
    }

}