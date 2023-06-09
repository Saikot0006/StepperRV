package com.example.stepperrv

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var stepRV : RecyclerView
    private lateinit var nextID : Button
    private var mList: ArrayList<StepperModel> = ArrayList()
    private lateinit var steppersAdapter: SteppersAdapter
    private var isSelectedText : Int = 1
    private var isCompleteText = false
    private var checkPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stepRV = findViewById(R.id.stepRV)
        nextID = findViewById(R.id.nextID)


        mList.add(StepperModel(1,false,false))
        mList.add(StepperModel(2,false,false))
        mList.add(StepperModel(3,false,false))
        mList.add(StepperModel(4,false,false))
        mList.add(StepperModel(5,false,false))
        mList.add(StepperModel(6,false,false))
        mList.add(StepperModel(7,false,false))
        mList.add(StepperModel(8,false,false))
        mList.add(StepperModel(9,false,false))



        steppersAdapter = SteppersAdapter({binding, value, model ->
            if(checkPosition==value){
                //val m = StepperModel(checkPosition+1,false,true)
                if(model.isCompleted.equals(false)){
                    binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.select_button)
                }
                Log.e("model", "onCreate: hhhh"+model )
                nextID.setOnClickListener {
                    model.isCompleted = true
                    model.isSelected = false
                    if(model.isCompleted.equals(true)){
                        binding.stepperText.setTextColor(resources.getColor(R.color.white))
                        binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.complete)
                    }
                }
            }else{
                if(model.isCompleted.equals(false)){
                    binding.stepperText.setTextColor(resources.getColor(R.color.green))
                    binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.round_button)
                }
            }


            binding.stepperText.setOnClickListener {

                stepRV.scrollToPosition(mList.size - (mList.size-(value+2)) )

                if(model.isCompleted.equals(true)){
                    model.isSelected = true
                    model.isCompleted = true
                    Log.e("model", "onCreate: "+model)
                    binding.stepperText.setTextColor(resources.getColor(R.color.white))
                    binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.complete)
                    val m = StepperModel(checkPosition+1,false,true)
                    checkPosition = value
                    steppersAdapter.notifyItemChanged(steppersAdapter.currentList.indexOf(m))

                }
                else if(model.isCompleted.equals(false)){

                    if(model.isSelected.equals(false)){
                        Toast.makeText(this@MainActivity, ""+value, Toast.LENGTH_SHORT).show()
                        binding.stepperText.setTextColor(resources.getColor(R.color.green))
                        binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.select_button)
                        val m = StepperModel(checkPosition+1,false)
                        checkPosition = value
                        steppersAdapter.notifyItemChanged(steppersAdapter.currentList.indexOf(m))

                    }

                }

                nextID.setOnClickListener {
                    model.isCompleted = true
                    if(model.isCompleted.equals(true)){
                        binding.stepperText.setTextColor(resources.getColor(R.color.white))
                        binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.complete)
                    }

                }


            }
        })



        stepRV.apply {
            layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            adapter = steppersAdapter
        }

        steppersAdapter.submitList(mList)


    }
}