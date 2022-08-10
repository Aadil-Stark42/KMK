package com.mindnotix.kmk.activitys.genres

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.activitys.BaseActivity
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.ActivityGenresListBinding
import com.mindnotix.kmk.databinding.GenresDetailListItemBinding
import com.mindnotix.kmk.databinding.GenresListItemBinding
import com.mindnotix.kmk.support.ToolbarSupport
import com.mindnotix.kmk.utils.Constant
import java.util.ArrayList

class GenresListActivity : BaseActivity() {
    private lateinit var binding: ActivityGenresListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_genres_list)
        initviews()
        GenresListSetup()
    }

    private fun initviews() {
        intent.getStringExtra(Constant.GENRES_NAME)
            ?.let { ToolbarSupport(it, binding.toolbar, this) }


    }

    private fun GenresListSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.slider_1)
        list.add(R.drawable.slider_2)
        list.add(R.drawable.trending_1)
        list.add(R.drawable.top_result_1)
        list.add(R.drawable.moview_detail_1)
        list.add(R.drawable.recent_3)
        list.add(R.drawable.recent_2)
        list.add(R.drawable.recent_1)
        list.add(R.drawable.more_result_1)
        list.add(R.drawable.more_result_2)
        list.add(R.drawable.more_result_3)
        list.add(R.drawable.more_result_4)
        list.add(R.drawable.top_result_1)
        list.add(R.drawable.recent_3)
        list.add(R.drawable.recent_2)
        list.add(R.drawable.recent_1)
        list.add(R.drawable.more_result_1)
        list.add(R.drawable.more_result_2)
        list.add(R.drawable.more_result_3)
        list.add(R.drawable.more_result_4)
        list.add(R.drawable.top_result_1)
        list.add(R.drawable.recent_2)
        RvGenresAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvGenresAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.genres_detail_list_item)
        binding.RvGenresDetailList.layoutManager = GridLayoutManager(
            this,
            2
        )
        binding.RvGenresDetailList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: GenresDetailListItemBinding =
                viewDataBinding as GenresDetailListItemBinding
            binding.imgGenresThubnail.setImageResource(data[position])
        }
    }
}