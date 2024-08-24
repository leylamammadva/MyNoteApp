package com.academy.mynoteapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import az.altacademy.androidgroup2.databinding.NoteLayoutBinding
import com.academy.mynoteapp.fragment.HomeFragmentDirections
import com.academy.mynoteapp.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.bind(currentNote)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NoteViewHolder(private val itemBinding: NoteLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(note: Note) {
            itemBinding.noteTitle.text = note.notesTitle
            itemBinding.noteDesc.text = note.noteDescription

            itemView.setOnClickListener {
                val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(note)
                it.findNavController().navigate(direction)
            }
        }
    }
}
