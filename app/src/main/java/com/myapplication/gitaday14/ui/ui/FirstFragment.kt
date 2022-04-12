package com.myapplication.gitaday14.ui.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.FragmentFirstBinding
import com.myapplication.gitaday14.ui.App
import com.myapplication.gitaday14.ui.model.Cookie
import com.myapplication.gitaday14.ui.model.Cookies
import com.myapplication.gitaday14.ui.utils.getJsonDataFromAsset
import com.myapplication.gitaday14.ui.utils.loadImage
import com.myapplication.gitaday14.ui.viewmodels.CookieViewModelFactory
import com.myapplication.gitaday14.ui.viewmodels.FirstFragmentViewModel
import kotlinx.coroutines.*


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    private val viewModel: FirstFragmentViewModel by viewModels {
        CookieViewModelFactory((activity?.application as App).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        addInDatabase()
        this.lastCookie()
        return binding.root
    }

    private fun mapJsonToData(): Cookies {
        val jsonFileString = getJsonDataFromAsset(requireContext(), "cookiedata.json")
        return Gson().fromJson(jsonFileString, Cookies::class.java)

    }

    private fun addInDatabase() {
        val cookies = mapJsonToData().cookies
        viewModel._allCookies.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                for (data in cookies) {
                    viewModel.insert(data)
                }

            }
        }
    }


    private fun lastCookie() {
        viewModel._allCookies.observe(viewLifecycleOwner) {
            val cookie = it.last()
            binding.nameTxt.loadImage(cookie.name)
            binding.flavorTxt.text = cookie.flavour
            binding.weightTxt.text = cookie.weight
            binding.expDateTxt.text = cookie.expDate
            binding.brandTxt.text = cookie.brand
        }
    }


    private fun openSecondFragment() {
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.first_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.SHOW_ALL -> {
                openSecondFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }

    }

}