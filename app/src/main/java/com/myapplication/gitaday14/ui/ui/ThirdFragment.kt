package com.myapplication.gitaday14.ui.ui

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.FragmentThirdBinding
import com.myapplication.gitaday14.ui.utils.loadImage


class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            binding.flavorTxt.text = bundle.getString("flavour")
            binding.brandTxt.text = bundle.getString("brand")
            binding.expDateTxt.text = bundle.getString("expDate")
            binding.weightTxt.text = bundle.getString("weight")
            bundle.getString("name")?.let { binding.nameTxt.loadImage(it) }


        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_cookie_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addCookie -> {
                openFourthFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openFourthFragment() {
        findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
    }


}