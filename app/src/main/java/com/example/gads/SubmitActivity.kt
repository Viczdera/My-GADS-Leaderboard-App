package com.example.gads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gads.Apis.RetrofitClient
import com.example.gads.Model.DefaultSubmitResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_submit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)



        btn2_submit.setOnClickListener {

            val firstname = editTextFstName.text.toString().trim()
            val lastname = editTextLstName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val gitproject = editTextProject.text.toString().trim()

            if(email.isEmpty()){
                    editTextEmail.error = "No email, no submission"
                    editTextEmail.requestFocus()
                    return@setOnClickListener
                }
            if(lastname.isEmpty()){
                editTextLstName.error = "Fill the required fields"
                editTextLstName.requestFocus()
                return@setOnClickListener
            }
            if(firstname.isEmpty()){
                editTextFstName.error = "Fill the required fields"
                editTextFstName.requestFocus()
                return@setOnClickListener
            }

            if(gitproject.isEmpty()){
                editTextProject.error = "Fill the required fields"
                editTextProject.requestFocus()
                return@setOnClickListener
            }


            RetrofitClient.instance.formResponse(
                email, firstname, lastname, gitproject
            ).enqueue(object : Callback<DefaultSubmitResponse>{
                override fun onFailure(p0: Call<DefaultSubmitResponse>?, p1: Throwable?) {
                    Toast.makeText(applicationContext, p1?.message,Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    p0: Call<DefaultSubmitResponse>?,
                    p1: Response<DefaultSubmitResponse>?
                ) {
                    Toast.makeText(applicationContext, p1?.body()?.Message,Toast.LENGTH_LONG).show()

                }

            })


        }

    }

}