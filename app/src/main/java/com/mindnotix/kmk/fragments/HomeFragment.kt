package com.mindnotix.kmk.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindnotix.kmk.R
import com.mindnotix.kmk.activitys.moviedetails.MovieDetailsActivity
import com.mindnotix.kmk.adapters.HomeSliderAdapter
import com.mindnotix.kmk.adapters.MyMasterRecyclerAdapter
import com.mindnotix.kmk.databinding.FragmentHomeBinding
import com.mindnotix.kmk.databinding.PopularListItemBinding
import java.util.ArrayList

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        SliderSetup()
        PopularListSetup()
        return binding.root
    }


    private fun SliderSetup() {
        binding.pager.adapter = HomeSliderAdapter(requireActivity())
        binding.dotsIndicator.setViewPager(binding.pager)
        binding.pager.offscreenPageLimit = 3
        binding.pager.pageMargin = resources.getDimensionPixelOffset(R.dimen._minus90sdp)

    }

    private fun PopularListSetup() {
        val list: ArrayList<String> = ArrayList()
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        RvPopularAdapter(list)
    }

    @SuppressLint("SetTextI18n")
    private fun RvPopularAdapter(data: ArrayList<String>) {
        val recyclerAdapter = MyMasterRecyclerAdapter(data, R.layout.popular_list_item)
        binding.RvPopularList.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.RvPopularList.adapter = recyclerAdapter
        recyclerAdapter.setOnBind { viewDataBinding, position ->

            val binding: PopularListItemBinding = viewDataBinding as PopularListItemBinding
            binding.root.setOnClickListener {
                startActivity(Intent(activity, MovieDetailsActivity::class.java))
                requireActivity().overridePendingTransition(0,R.anim.fade)
            }

        }
    }
}