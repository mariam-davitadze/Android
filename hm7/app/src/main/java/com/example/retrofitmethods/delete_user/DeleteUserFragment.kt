package com.example.retrofitmethods.delete_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.retrofitmethods.databinding.DeleteUserFragmentBinding
import com.example.retrofitmethods.delete_user.DeleteUserViewModel

class DeleteUserFragment : Fragment() {

    private val viewModel: DeleteUserViewModel by viewModels()

    private lateinit var binding: DeleteUserFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DeleteUserFragmentBinding.inflate(inflater, container, false)
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
            deleteBtn.setOnClickListener {
                viewModel.deleteUser(nameEditText.text.toString(), jobEditText.text.toString())
                nameEditText.setText("")
                jobEditText.setText("")
            }
        }
    }

}