package com.example.gads.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gads.Adapters.MyRecyclerViewAdapter
import com.example.gads.Model.HrItem
import com.example.gads.Apis.MyApiInterface
import com.example.gads.R
import kotlinx.android.synthetic.main.fragment_first.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**

 */
private var layoutManager: RecyclerView.LayoutManager?= null
private var adapter:RecyclerView.Adapter<MyRecyclerViewAdapter.HrViewHolder>? =null

class HRFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()


    }


    private fun fetchData(){

        //fetching data
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api= retrofit.create(MyApiInterface::class.java)


        api.getHr().enqueue(object : Callback<List<HrItem>> {
            override fun onResponse(p0: Call<List<HrItem>>?, p1: Response<List<HrItem>>?) {
                Log.d("daniel", "onResponse")

                val hr= mutableListOf<HrItem>()
                for (i in 0..100){
                    hr.add(HrItem("https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png", "Nigeria",30,"Victor"))
                }

                recycler_view.apply { activity
                    layoutManager =LinearLayoutManager(activity)
                    adapter= MyRecyclerViewAdapter(hr)
                }

            }



            override fun onFailure(p0: Call<List<HrItem>>?, p1: Throwable?) {
                Log.d("daniel", "onFailure")
            }

        })

    }







}