package com.diyorbek.roomdatabase_t1.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.diyorbek.roomdatabase_t1.R
import com.diyorbek.roomdatabase_t1.database.NumberDatabase
import com.diyorbek.roomdatabase_t1.database.NumberEntity
import com.diyorbek.roomdatabase_t1.databinding.FragmentFirstBinding
import com.diyorbek.roomdatabase_t1.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val database by lazy { NumberDatabase(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)

        allCode()
    }

    @SuppressLint("SetTextI18n")
    private fun allCode() {
        binding.btnSaveEdit.setOnClickListener {
            val num = arguments?.getString("number")
            binding.textNumber.text = num.toString()
            if (binding.code.text.toString() != "qwerty123") {
                Snackbar.make(requireView(), "Code is incorrect!", Snackbar.LENGTH_SHORT).show()
            } else {
                database.dao.saveNumber(NumberEntity(number = num.toString()))
                val bundle = bundleOf()
                bundle.putString("number2", num.toString())
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}