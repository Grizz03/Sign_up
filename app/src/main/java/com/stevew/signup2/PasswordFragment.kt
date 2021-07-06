package com.stevew.signup2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.stevew.signup2.databinding.FragmentPasswordBinding
import com.stevew.signup2.viewmodel.SignUpViewModel


class PasswordFragment : Fragment() {

    private var binding: FragmentPasswordBinding? = null

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.let { binding ->
            // storing text to view model
            binding.etPassword.doAfterTextChanged {
                    viewModel.password = it.toString()
                }

            // click listener
            binding.btnSubmit.setOnClickListener{
                val userPassword = binding.etPassword.text.toString() // create variables for edit text
                val userPasswordCheck = binding.etPasswordCheck.text.toString()
                if (userPassword.isNotEmpty() && userPasswordCheck.isNotEmpty()) { // checks if .. the edit text fields empty?
                    if (userPassword == userPasswordCheck) { // if they are not empty then .. do the passwords match?
                        findNavController().navigate(R.id.action_passwordFragment_to_userInfoFragment)
                    } else { // clears input fields if the passwords don't match and lets user know
                        Toast.makeText(context, "Passwords must be matching", Toast.LENGTH_SHORT).show()
                        binding.etPassword.text?.clear()
                        binding.etPasswordCheck.text?.clear()
                    }
                } else {
                    Toast.makeText(context, "Please enter a password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}