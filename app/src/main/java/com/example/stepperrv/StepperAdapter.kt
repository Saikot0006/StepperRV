package com.example.stepperrv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stepperrv.databinding.StepperRowItemBinding

class StepperAdapter(private val mList: List<String>) : RecyclerView.Adapter<StepperAdapter.StepperViewHolder>() {

    class StepperViewHolder(val binding: StepperRowItemBinding) : ViewHolder(binding.root){
        fun bind(position : String){
            binding.stepperText.text = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepperViewHolder {
        val binding = StepperRowItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return StepperViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: StepperViewHolder, position: Int) {
        holder.bind(position.toString())
        holder.binding.stepperText.setOnClickListener {
            val context = holder.binding.stepperText.context
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show()
            holder.binding.stepperText.background = ContextCompat.getDrawable(context,R.drawable.select_button)
        }
    }
}