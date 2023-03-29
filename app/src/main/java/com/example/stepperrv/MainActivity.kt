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
        mList.add(StepperModel(10,false,false))
        mList.add(StepperModel(11,false,false))
        mList.add(StepperModel(12,false,false))
        mList.add(StepperModel(13,false,false))
        mList.add(StepperModel(14,false,false))
        mList.add(StepperModel(15,false,false))
        mList.add(StepperModel(16,false,false))
        mList.add(StepperModel(17,false,false))
        mList.add(StepperModel(18,false,false))
        mList.add(StepperModel(19,false,false))
        mList.add(StepperModel(20,false,false))



        steppersAdapter = SteppersAdapter({binding, value, model ->
            binding.stepperText.setOnClickListener {
                model.isSelected = true

                if(model.isSelected){
                    Toast.makeText(this@MainActivity, ""+value, Toast.LENGTH_SHORT).show()
                    binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.select_button)
                }


                nextID.setOnClickListener {
                    val model = StepperModel(value,false,true)
                    Log.e("model", "onCreate: "+model)
                    if(model.isCompleted && model.id == value){
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