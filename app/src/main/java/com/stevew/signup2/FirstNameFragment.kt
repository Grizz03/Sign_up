package com.stevew.signup2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.stevew.signup2.databinding.FragmentFirstNameBinding
import com.stevew.signup2.viewmodel.SignUpViewModel

class FirstNameFragment : Fragment() {

    companion object {
        fun newInstance() = FirstNameFragment()
    }

    private var binding: FragmentFirstNameBinding? = null

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstNameBinding.inflate(inflater, container, false)
        return binding?.root
    }
// what happens when view is created ->
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getting reference to view model
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.let { binding ->
            // adds text listener to input field to store the string
            binding.etFirstName.doAfterTextChanged {
                viewModel.firstName = it.toString()
            }
            // last name listener to add to view model
            binding.etLastName.doAfterTextChanged {
                viewModel.lastName = it.toString()
            }

            binding.btnSubmit.setOnClickListener {
                if (viewModel.firstName.isNotEmpty())
                    findNavController().navigate(R.id.action_firstNameFragment_to_emailFragment2)
            }
        }
    }
// destroy any unwanted bindings that may hog up memory
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

