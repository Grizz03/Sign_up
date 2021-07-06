package com.stevew.signup2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stevew.signup2.databinding.FragmentUserInfoBinding
import com.stevew.signup2.viewmodel.SignUpViewModel

class UserInfoFragment : Fragment() {

    private var binding: FragmentUserInfoBinding? = null

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.tvFirstName?.text = viewModel.firstName
        binding?.tvLastName?.text = viewModel.lastName
        binding?.tvEmail?.text = viewModel.email
        binding?.tvPassword?.text = viewModel.password
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}