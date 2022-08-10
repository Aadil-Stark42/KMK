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
import com.mindnotix.kmk.databinding.ActivityGenresBinding
import com.mindnotix.kmk.databinding.GenresListItemBinding
import com.mindnotix.kmk.databinding.WatchListItemBinding
import com.mindnotix.kmk.support.ToolbarSupport
import com.mindnotix.kmk.utils.Constant
import java.util.ArrayList

class GenresActivity : BaseActivity() {
    private lateinit var binding: ActivityGenresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_genres)
        initviews()
        GenresListSetup()
    }

    private fun initviews() {
        ToolbarSupport(getString(R.string.genres), binding.toolbar, this)
    }

    private fun GenresListSetup() {
        val list: ArrayList<String> = ArrayList()
        list.add("Action")
        list.add("Comedy")
        list.add("Drama")
        list.add("Fantasy")
        list.add("Horror")
        list.add("Romance")
        list.add("Thriller")

        RvGenresAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvGenresAdapter(data: ArrayList<String>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.genres_list_item)
        binding.RvGenresList.layoutManager = GridLayoutManager(
            this,
            2
        )
        binding.RvGenresList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: GenresListItemBinding =
                viewDataBinding as GenresListItemBinding
            binding.txtGenresTitle.text = data[position]
            binding.root.setOnClickListener {
                startActivity(Intent(this, GenresListActivity::class.java).putExtra(Constant.GENRES_NAME,binding.txtGenresTitle.text.toString()))
                overridePendingTransition(0, R.anim.fade)

            }
        }
    }
}