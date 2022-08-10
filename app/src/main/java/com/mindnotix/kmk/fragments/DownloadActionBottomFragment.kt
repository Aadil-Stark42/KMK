package com.mindnotix.kmk.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mindnotix.kmk.R
import com.mindnotix.kmk.databinding.FragmentDownloadActionBottomBinding


class DownloadActionBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDownloadActionBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_download_action_bottom,
            container,
            false
        )
        return binding.root
    }


}