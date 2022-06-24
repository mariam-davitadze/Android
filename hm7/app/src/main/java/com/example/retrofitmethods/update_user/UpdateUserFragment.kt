package com.example.retrofitmethods.update_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.retrofitmethods.databinding.UpdateUserFragmentBinding

class UpdateUserFragment : Fragment() {

    private val viewModel: UpdateUserViewModel by viewModels()

    private lateinit var binding: UpdateUserFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UpdateUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel.errorLiveData.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
            viewModel.userLiveData.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
            updateUserBtn.setOnClickListener {
                viewModel.updateUser(nameEditText.text.toString(), jobEditText.text.toString())
                nameEditText.setText("")
                jobEditText.setText("")
            }
        }
    }

}