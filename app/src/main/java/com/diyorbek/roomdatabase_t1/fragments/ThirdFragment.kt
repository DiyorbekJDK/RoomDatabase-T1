package com.diyorbek.roomdatabase_t1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyorbek.roomdatabase_t1.R
import com.diyorbek.roomdatabase_t1.adapter.NumberAdapter
import com.diyorbek.roomdatabase_t1.database.NumberDatabase
import com.diyorbek.roomdatabase_t1.databinding.FragmentSecondBinding
import com.diyorbek.roomdatabase_t1.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val database by lazy { NumberDatabase(requireContext()) }
    private val adapter2 by lazy { NumberAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentThirdBinding.bind(view)

        allCode()
    }

    private fun allCode() {
        binding.textView2.text = arguments?.getString("number2").toString()
        binding.rv.apply {
            adapter = adapter2
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapter2.setList(database.dao.getAllNumbers().toMutableList())
        adapter2.notifyDataSetChanged()
        adapter2.onClick = {
            val bundle = bundleOf("numberr" to it)
            findNavController().navigate(R.id.action_thirdFragment_to_detailFragment, bundle)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}