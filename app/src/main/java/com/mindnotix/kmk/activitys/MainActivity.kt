package com.mindnotix.kmk.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mindnotix.kmk.R
import com.mindnotix.kmk.databinding.ActivityMainBinding
import com.mindnotix.kmk.fragments.HomeFragment
import com.mindnotix.kmk.fragments.SearchFragment

import androidx.fragment.app.FragmentTransaction
import com.mindnotix.kmk.activitys.genres.GenresActivity
import com.mindnotix.kmk.activitys.preference.PreferenceActivity
import com.mindnotix.kmk.activitys.watchlist.WatchListActivity


class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initviews()
        LoadFragment(HomeFragment())
        ClickEvents()
        MenuSetup()
    }

    private fun MenuSetup() {
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, binding.drawerLayout,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
    }

    private fun initviews() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.view_black)

    }

    private fun ClickEvents() {
        binding.llHome.setOnClickListener {
            UnFillView()
            binding.dotHome.visibility = View.VISIBLE
            binding.dotSearch.visibility = View.GONE
            LoadFragment(HomeFragment())
        }
        binding.llSearch.setOnClickListener {
            UnFillView()
            binding.dotHome.visibility = View.GONE
            binding.dotSearch.visibility = View.VISIBLE
            LoadFragment(SearchFragment())
        }
        binding.llMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }
        binding.llDownload.setOnClickListener {
            startActivity(Intent(this, DownloadActivity::class.java))
            overridePendingTransition(0, R.anim.fade)
        }
        binding.llWatchList.setOnClickListener {
            startActivity(Intent(this, WatchListActivity::class.java))
            overridePendingTransition(0, R.anim.fade)
        }
        binding.llGenres.setOnClickListener {
            startActivity(Intent(this, GenresActivity::class.java))
            overridePendingTransition(0, R.anim.fade)
        }
        binding.llHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
            overridePendingTransition(0, R.anim.fade)
        }
        binding.llPrefrence.setOnClickListener {
            startActivity(Intent(this, PreferenceActivity::class.java))
            overridePendingTransition(0, R.anim.fade)
        }
    }

    private fun UnFillView() {
        binding.imgHome.setImageResource(R.drawable.ic_home)
        binding.dotHome.visibility = View.GONE
        binding.dotSearch.visibility = View.GONE

    }


    private fun LoadFragment(fragment: Fragment) {
        binding.container.removeAllViews()
        val transaction1: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction1.add(R.id.container, fragment)
        transaction1.commit()
    }

}