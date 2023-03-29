package com.example.stepperrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stepperrv.databinding.StepperRowItemBinding

class SteppersAdapter(
    private val callback : (binding: StepperRowItemBinding,value : Int,model: StepperModel) -> Unit) :
    ListAdapter<StepperModel,SteppersAdapter.SteppersViewHolder>(SteppersDiffUtill()) {

    class SteppersViewHolder(val binding: StepperRowItemBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun bind(model: StepperModel){
                binding.model = model
            }
        }

    class SteppersDiffUtill : DiffUtil.ItemCallback<StepperModel>(){
        override fun areItemsTheSame(oldItem: StepperModel, newItem: StepperModel): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: StepperModel, newItem: StepperModel): Boolean {
            return  oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SteppersViewHolder {
        val binding = StepperRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SteppersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SteppersViewHolder, position: Int) {
        var data = getItem(position)
        holder.bind(data)
        callback(holder.binding,position,data)
    }
}