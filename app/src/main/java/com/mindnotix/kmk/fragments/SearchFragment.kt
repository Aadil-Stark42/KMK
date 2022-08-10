package com.mindnotix.kmk.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.FragmentSearchBinding
import com.mindnotix.kmk.databinding.RecentSearchListBinding
import com.mindnotix.kmk.databinding.TrendingListItemBinding
import java.util.ArrayList
import android.text.Editable

import android.text.TextWatcher
import com.mindnotix.kmk.activitys.moviedetails.MovieDetailsActivity
import com.mindnotix.kmk.databinding.TopResultListItemBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        TrendingSetup()
        RecentSetup()
        TopResultSetup()
        MoreResultSetup()
        ClickEvents()
        SearchListner()
        return binding.root

    }

    private fun SearchListner() {
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (binding.edtSearch.text.isNotEmpty()) {
                    binding.llMoreResult.visibility = View.VISIBLE
                    binding.llTopResults.visibility = View.VISIBLE
                    binding.llRecentSearch.visibility = View.GONE
                } else {
                    binding.llMoreResult.visibility = View.GONE
                    binding.llTopResults.visibility = View.GONE
                    binding.llRecentSearch.visibility = View.VISIBLE

                }
            }

        })
    }

    private fun ClickEvents() {
        binding.imgSearchclick.setOnClickListener {
            binding.llinitSearch.visibility = View.VISIBLE
            binding.llBaseSearch.visibility = View.GONE
        }
        binding.imgBack.setOnClickListener {
            binding.llinitSearch.visibility = View.GONE
            binding.llBaseSearch.visibility = View.VISIBLE
        }
    }

    private fun TrendingSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.trending_1)
        list.add(R.drawable.trending_2)
        list.add(R.drawable.trending_3)
        list.add(R.drawable.trending_4)
        list.add(R.drawable.trending_5)
        list.add(R.drawable.trending_6)

        RvTrendingAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvTrendingAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.trending_list_item)
        binding.RvTrendingSearch.layoutManager = GridLayoutManager(
            activity,
            2
        )
        binding.RvTrendingSearch.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->

            val binding: TrendingListItemBinding = viewDataBinding as TrendingListItemBinding
            binding.imgTrending.setImageResource(data[position])
            binding.root.setOnClickListener {
                startActivity(Intent(activity, MovieDetailsActivity::class.java))
                requireActivity().overridePendingTransition(0,R.anim.fade)
            }
        }
    }

    private fun RecentSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.recent_1)
        list.add(R.drawable.recent_2)
        list.add(R.drawable.recent_3)

        val lists: ArrayList<String> = ArrayList()
        lists.add("Karnan")
        lists.add("Doctor")
        lists.add("Jai Bhim")
        RvRecentAdapter(list, lists)
    }

    @SuppressLint("SetTextI18n")
    private fun RvRecentAdapter(data: ArrayList<Int>, lists: ArrayList<String>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.recent_search_list)
        binding.RvRecentList.layoutManager = GridLayoutManager(
            activity,
            1
        )
        binding.RvRecentList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: RecentSearchListBinding = viewDataBinding as RecentSearchListBinding
            binding.imgRecent.setImageResource(data[position])
            binding.txtRecent.setText(lists[position])
            binding.root.setOnClickListener {
                startActivity(Intent(activity, MovieDetailsActivity::class.java))
                requireActivity().overridePendingTransition(0,R.anim.fade)
            }
        }
    }

    private fun TopResultSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.recent_1)

        RvTopResultAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvTopResultAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.top_result_list_item)
        binding.RvTopList.layoutManager = GridLayoutManager(
            activity,
            1
        )
        binding.RvTopList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->
            val binding: TopResultListItemBinding = viewDataBinding as TopResultListItemBinding
            binding.root.setOnClickListener {
                startActivity(Intent(activity, MovieDetailsActivity::class.java))
            }
        }
    }

/*----------*/

    private fun MoreResultSetup() {
        val list: ArrayList<Int> = ArrayList()
        list.add(R.drawable.more_result_1)
        list.add(R.drawable.more_result_2)
        list.add(R.drawable.more_result_3)
        list.add(R.drawable.more_result_4)


        MoreResultAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun MoreResultAdapter(data: ArrayList<Int>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.trending_list_item)
        binding.RvMoreResult.layoutManager = GridLayoutManager(
            activity,
            2
        )
        binding.RvMoreResult.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->

            val binding: TrendingListItemBinding = viewDataBinding as TrendingListItemBinding
            binding.imgTrending.setImageResource(data[position])
            binding.root.setOnClickListener {
                startActivity(Intent(activity, MovieDetailsActivity::class.java))
                requireActivity().overridePendingTransition(0,R.anim.fade)
            }
        }
    }
}