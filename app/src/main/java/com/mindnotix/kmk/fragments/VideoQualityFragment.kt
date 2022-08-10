package com.mindnotix.kmk.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mindnotix.kmk.R
import com.mindnotix.kmk.databinding.FragmentVideoQualityBinding

class VideoQualityFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentVideoQualityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_video_quality, container, false)
        ClickEvents()
        return binding.root

    }

    private fun ClickEvents() {
        binding.llAuto.setOnClickListener {
            RemoveSelection()
            binding.imgAuto.setImageResource(R.drawable.ic_selected_video_quality)
        }
        binding.ll480.setOnClickListener {
            RemoveSelection()
            binding.img480.setImageResource(R.drawable.ic_selected_video_quality)
        }
        binding.ll720.setOnClickListener {
            RemoveSelection()
            binding.img720.setImageResource(R.drawable.ic_selected_video_quality)
        }
        binding.ll1080.setOnClickListener {
            RemoveSelection()
            binding.img1080.setImageResource(R.drawable.ic_selected_video_quality)
        }
    }

    private fun RemoveSelection() {
        binding.imgAuto.setImageResource(R.drawable.ic_un_selected_video_quality)
        binding.img480.setImageResource(R.drawable.ic_un_selected_video_quality)
        binding.img720.setImageResource(R.drawable.ic_un_selected_video_quality)
        binding.img1080.setImageResource(R.drawable.ic_un_selected_video_quality)
    }

}