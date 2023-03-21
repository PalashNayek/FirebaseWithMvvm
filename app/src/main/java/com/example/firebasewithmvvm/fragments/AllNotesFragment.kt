package com.example.firebasewithmvvm.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasewithmvvm.adapter.AllNotesAdapter
import com.example.firebasewithmvvm.databinding.FragmentAllNotesBinding
import com.example.firebasewithmvvm.viewmodel.AllNotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllNotesFragment : Fragment() {
    private var _binding: FragmentAllNotesBinding? = null
    private val binding get() = _binding!!

    private val allNotesViewModel by viewModels<AllNotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val adapter = AllNotesAdapter()

        allNotesViewModel.getAllNotes().observe(viewLifecycleOwner, Observer {
            Log.d("MyResponse","$it")
            adapter.submitList(it)
            recyclerView.adapter = adapter
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}