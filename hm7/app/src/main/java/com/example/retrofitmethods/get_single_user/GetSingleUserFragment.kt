package com.example.retrofitmethods.get_single_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.retrofitmethods.databinding.GetSingleUserFragmentBinding
import com.example.retrofitmethods.get_single_user.GetSingleUserViewModel

class GetSingleUserFragment : Fragment() {

    private val viewModel: GetSingleUserViewModel by viewModels()

    private lateinit var binding: GetSingleUserFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GetSingleUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel.errorLiveData.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
            viewModel.userLiveData.observe(viewLifecycleOwner){
                email.text = it.email
                firstName.text = it.first_name
                lastName.text = it.last_name
            }
        }
    }


}