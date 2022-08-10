package com.mindnotix.kmk.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import com.mindnotix.kmk.R
import com.mindnotix.kmk.activitys.moviedetails.MovieDetailsActivity

class HomeSliderAdapter(var activity: FragmentActivity) : PagerAdapter() {
    lateinit var layoutInflater: LayoutInflater
    lateinit var context: Context
    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(activity)
        var view = layoutInflater.inflate(R.layout.home_slider_item, container, false)

/*

        val img = view.findViewById<ImageView>(R.id.imgSlider)


        img.setImageResource(list[position])
*/
        view.setOnClickListener {
            activity.startActivity(Intent(activity, MovieDetailsActivity::class.java))
            activity.overridePendingTransition(0, R.anim.fade)
        }
        container.addView(view, 0)

        return view


    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)


    }


}