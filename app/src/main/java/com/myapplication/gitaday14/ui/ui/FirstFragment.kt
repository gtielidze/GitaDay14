package com.myapplication.gitaday14.ui.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.myapplication.gitaday14.R
import com.myapplication.gitaday14.databinding.FragmentFirstBinding
import com.myapplication.gitaday14.ui.database.CookieDataBase
import com.myapplication.gitaday14.ui.model.Cookie
import com.myapplication.gitaday14.ui.model.Cookies
import com.myapplication.gitaday14.ui.utils.getJsonDataFromAsset
import com.myapplication.gitaday14.ui.viewmodels.FirstFragmentViewModel
import kotlinx.coroutines.*


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    private val viewModel: FirstFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        addInDatabase()
        initialize()

        return binding.root
    }

    private fun mapJsonToData(): Cookies {
        val jsonFileString = getJsonDataFromAsset(requireContext(), "cookiedata.json")
        return Gson().fromJson(jsonFileString, Cookies::class.java)

    }

    private fun addInDatabase() {
        val cookies = mapJsonToData().cookies
        val applicationScope = CoroutineScope(SupervisorJob())
        val db = CookieDataBase.invoke(requireContext(), applicationScope)
        CoroutineScope(Dispatchers.IO).launch  {
            val check = db.getCookieDao().exists(1)
            if (!check) {
                for (data in cookies) {
                    db.getCookieDao().addCookie(data)
                }
            }
        }
    }

    private fun initialize() {

        var data:Cookie? = null
        CoroutineScope(Dispatchers.IO).launch {
            val applicationScope = CoroutineScope(SupervisorJob())
            val db = CookieDataBase.invoke(requireContext(),applicationScope)
            val cookie = db.getCookieDao().selectLast().get(0)
            data = cookie
            binding.brandTxt.text = cookie?.name.toString()
            binding.flavorTxt.text = cookie?.flavour.toString()
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