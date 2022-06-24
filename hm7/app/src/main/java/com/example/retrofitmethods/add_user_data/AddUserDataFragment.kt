package com.example.retrofitmethods.add_user_data


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.retrofitmethods.databinding.RegistrationFragmentBinding

class AddUserDataFragment : Fragment() {

    private val viewModel: AddUserDataViewModel by viewModels()

    private lateinit var binding: RegistrationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistrationFragmentBinding.inflate(inflater, container, false)
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
            addBtn.setOnClickListener {
                viewModel.addUser(nameEditText.text.toString(), jobEditText.text.toString())
                nameEditText.setText("")
                jobEditText.setText("")
            }
        }
    }

}