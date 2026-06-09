package com.blas.creditappdemo.ui.list
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blas.creditappdemo.databinding.TextRowItemBinding

class CustomAdapter (private val dataSet: Array<String>) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = TextRowItemBinding.inflate(
        LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
        }