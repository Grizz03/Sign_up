package com.stevew.signup2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.stevew.signup2.databinding.FragmentEmailBinding
import com.stevew.signup2.viewmodel.SignUpViewModel

class EmailFragment : Fragment() {

    private var binding: FragmentEmailBinding? = null

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializes view model
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.let { binding ->
            binding.etEmail.doAfterTextChanged {
                viewModel.email = it.toString()
            }

            binding.btnSubmit.setOnClickListener {
                if (viewModel.email.isNotEmpty())
                    findNavController().navigate(R.id.action_emailFragment_to_passwordFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}