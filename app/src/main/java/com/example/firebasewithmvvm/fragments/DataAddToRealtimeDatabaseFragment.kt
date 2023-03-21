package com.example.firebasewithmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.firebasewithmvvm.R
import com.example.firebasewithmvvm.databinding.FragmentDataAddToRealtimeDatabaseBinding
import com.example.firebasewithmvvm.model.NoteModel
import com.example.firebasewithmvvm.viewmodel.AddToDataRealtimeDBViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataAddToRealtimeDatabaseFragment : Fragment() {
    private var _binding: FragmentDataAddToRealtimeDatabaseBinding? = null
    private val binding get() = _binding!!

    private val realtimeDBViewModel by viewModels<AddToDataRealtimeDBViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataAddToRealtimeDatabaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //submit button click
        binding.btnSubmit.setOnClickListener {
            /*realtimeDBViewModel.addDataToRealtimeDB(
                binding.txtTitle.text.toString(),
                binding.txtDescription.text.toString()
            )*/
            realtimeDBViewModel.saveNotes(NoteModel(binding.txtTitle.text.toString(),
                binding.txtDescription.text.toString()))
            findNavController().navigate(R.id.action_dataAddToRealtimeDatabaseFragment_to_allNotesFragment)
        }

        /*realtimeDBViewModel.realtimeDBResponse.observe(viewLifecycleOwner, Observer {
            val success = it
            if (success.equals("Data saved successful")){
                findNavController().navigate(R.id.action_dataAddToRealtimeDatabaseFragment_to_allNotesFragment)
            }
        })*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}