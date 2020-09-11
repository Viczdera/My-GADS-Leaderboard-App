package com.example.gads.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gads.fragments.HRFragment
import com.example.gads.fragments.IQFragment

class VictorsPageAdapter(fm: FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {HRFragment()}
            1-> {IQFragment()}
            else-> {
                return HRFragment()
            }
        }
    }

    override fun getCount(): Int {
       return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "Learning Leaders"
            1-> "Skill IQ Leaders"
            else-> {
                return "Learning Leaders"
            }
        }
    }
}