package com.myapplication.gitaday14.ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.FragmentSecondBinding
import com.myapplication.gitaday14.ui.App
import com.myapplication.gitaday14.ui.adapter.MyAdapter
import com.myapplication.gitaday14.ui.viewmodels.CookieViewModelFactory
import com.myapplication.gitaday14.ui.viewmodels.FirstFragmentViewModel


class SecondFragment : Fragment() {
    private val viewModel: FirstFragmentViewModel by viewModels {
        CookieViewModelFactory((activity?.application as App).repository)
    }

    private lateinit var binding: FragmentSecondBinding

    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        initRecycler()
        observe()
        return binding.root
    }

    private fun initRecycler() {
        adapter = MyAdapter() {
            setFragmentResult(
                "requestKey",
                bundleOf(
                    "flavour" to it.flavour,
                    "name" to it.name,
                    "brand" to it.brand,
                    "expDate" to it.expDate,
                    "weight" to it.weight
                )
            )
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        binding.cookiesRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.cookiesRecyclerView.adapter = adapter

    }

    private fun observe() {
        viewModel._allCookies.observe(viewLifecycleOwner) {
            adapter.setCoolieListItem(it.toMutableList())
        }
    }

}