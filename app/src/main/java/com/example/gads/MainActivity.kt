package com.example.gads

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gads.Adapters.VictorsPageAdapter
import com.example.gads.Model.HrItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            startActivity(intent)
        }

        val pageAdapter=
            VictorsPageAdapter(supportFragmentManager)
        action_viewpager.adapter = pageAdapter
        tabs.setupWithViewPager(action_viewpager)




    }

    fun openSubmit(view: View){

    }



}