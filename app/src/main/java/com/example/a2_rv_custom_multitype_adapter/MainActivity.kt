package com.example.a2_rv_custom_multitype_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_rv_custom_multitype_adapter.adapter.CustomAdapter
import com.example.a2_rv_custom_multitype_adapter.model.User

private lateinit var recyclerView: RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val users = prepareUserList()
        refreshAdapter(users)
    }

    private fun prepareUserList(): List<User> {
        val users = ArrayList<User>()
        for (i in 0..30){
            if (i==2||i==5||i==10||i==15 ||i==22){
                users.add(User("Tohir "+i,false))
            }
            else{
                users.add(User("Abubakr "+i,true))
            }
        }
        return users
    }

    private fun refreshAdapter(users: List<User>) {
        val adapter = CustomAdapter(users)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)
    }



}