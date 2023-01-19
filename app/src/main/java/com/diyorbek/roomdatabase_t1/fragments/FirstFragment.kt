package com.diyorbek.roomdatabase_t1.fragments

import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.diyorbek.roomdatabase_t1.R
import com.diyorbek.roomdatabase_t1.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)

        allCode()
    }

    private fun allCode() {
        binding.btnSaveEdit.setOnClickListener {
            sendSms()
        }
    }

    private fun sendSms() {
        if (binding.number.text.isNullOrBlank()) {
            Snackbar.make(requireView(), "Enter Number!", Snackbar.LENGTH_SHORT).show()
        } else {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(
                binding.number.text?.toString()?.trim(),
                null,
                "qwerty123",
                null,
                null
            )
            Snackbar.make(requireView(), "Wait SMS...", Snackbar.LENGTH_LONG).show()
            val bundle = bundleOf()
            bundle.putString("number", binding.number.text.toString().trim())
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}