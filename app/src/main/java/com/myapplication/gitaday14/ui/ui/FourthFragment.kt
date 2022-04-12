package com.myapplication.gitaday14.ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.FragmentFourthBinding
import com.myapplication.gitaday14.ui.App
import com.myapplication.gitaday14.ui.model.Cookie
import com.myapplication.gitaday14.ui.viewmodels.CookieViewModelFactory
import com.myapplication.gitaday14.ui.viewmodels.FirstFragmentViewModel
import com.myapplication.gitaday14.ui.viewmodels.FourthFragmentViewModel


class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding
    private val viewModel: FirstFragmentViewModel by viewModels {
        CookieViewModelFactory((activity?.application as App).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourthBinding.inflate(inflater, container, false)

        binding.addCookieBtn.setOnClickListener {
            insert()
            findNavController().navigate(R.id.action_fourthFragment_to_firstFragment)
        }
        return binding.root
    }


    private fun insert() {
        val cookie = Cookie(
            name = binding.nameAddCookieTxt.text.toString(),
            brand = binding.brandAddCookieTxt.text.toString(),
            expDate = binding.expDateAddCookieTxt.text.toString(),
            flavour = binding.expDateAddCookieTxt.text.toString(),
        )
        viewModel.insert(cookie)

    }

}