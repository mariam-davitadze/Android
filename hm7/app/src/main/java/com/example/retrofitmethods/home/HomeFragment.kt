package com.example.retrofitmethods.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.retrofitmethods.R

import com.example.retrofitmethods.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            addUserDataBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_registrationFragment)
            }
            getSingleUserBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_getSingleUserFragment)
            }
            updateUserBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_updateUserFragment)
            }
            deleteUserBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_deleteUserFragment)
            }
        }
    }
}