package com.example.firebasewithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasewithmvvm.R
import com.example.firebasewithmvvm.model.NoteModel

import androidx.recyclerview.widget.ListAdapter

class AllNotesAdapter: ListAdapter<NoteModel,AllNotesAdapter.ProgrammingViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent,false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProgrammingViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val title = view.findViewById<TextView>(R.id.noteTile)
        private val desc = view.findViewById<TextView>(R.id.noteDesc)

        fun bind(item : NoteModel){
            title.text = item.noteName
            desc.text = item.noteDesc
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.noteName == newItem.noteName
        }

        override fun areContentsTheSame(
            oldItem: NoteModel,
            newItem: NoteModel
        ): Boolean {
            return oldItem == newItem
        }

    }
}