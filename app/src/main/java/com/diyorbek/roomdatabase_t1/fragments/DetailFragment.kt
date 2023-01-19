package com.diyorbek.roomdatabase_t1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.diyorbek.roomdatabase_t1.R
import com.diyorbek.roomdatabase_t1.adapter.NumberAdapter
import com.diyorbek.roomdatabase_t1.database.NumberDatabase
import com.diyorbek.roomdatabase_t1.databinding.FragmentDetailBinding
import com.diyorbek.roomdatabase_t1.databinding.FragmentThirdBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val database by lazy { NumberDatabase(requireContext()) }
    private val adapter2 by lazy { NumberAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        allCode()
    }

    private fun allCode() {
        binding.textView4.text = arguments?.getString("numberr").toString()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}