package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    private lateinit var adapter: UserRecyclerAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpAdapter()
        viewModel.errorLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        viewModel.usersLiveData.observe(this) {
            adapter.setUsersList(it)
        }
        viewModel.getUsersList()
    }

    private fun setUpAdapter() {
        adapter = UserRecyclerAdapter()
        binding.userRecycler.layoutManager = LinearLayoutManager(this)
        binding.userRecycler.adapter = adapter
    }
}