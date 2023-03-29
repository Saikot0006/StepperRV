package com.example.stepperrv

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var stepRV : RecyclerView
    private lateinit var nextID : Button
    private var mList: ArrayList<String> = ArrayList()
    private lateinit var stepperAdapter: StepperAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stepRV = findViewById(R.id.stepRV)
        nextID = findViewById(R.id.nextID)

        mList.add("1")
        mList.add("2")
        mList.add("3")
        mList.add("4")
        mList.add("5")
        mList.add("6")
        mList.add("7")
        mList.add("8")
        mList.add("9")
        mList.add("10")
        mList.add("11")
        mList.add("12")
        mList.add("13")
        mList.add("14")
        mList.add("15")
        mList.add("16")
        mList.add("17")
        mList.add("18")
        mList.add("19")
        mList.add("20")

        nextID.setOnClickListener {
            Toast.makeText(this@MainActivity, "value", Toast.LENGTH_SHORT).show()

            stepperAdapter = StepperAdapter(mList,{binding,value ->
                    Toast.makeText(this@MainActivity, ""+value, Toast.LENGTH_SHORT).show()
                    binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.complete)
                    binding.stepperText.setTextColor(Color.parseColor("#ffffff"))

            })
        }

        stepperAdapter = StepperAdapter(mList,{binding,value ->
            binding.stepperText.setOnClickListener {
                Toast.makeText(this@MainActivity, ""+value, Toast.LENGTH_SHORT).show()
                binding.stepperText.background = ContextCompat.getDrawable(this@MainActivity,R.drawable.select_button)

            }

        })

        stepRV.apply {
            layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            adapter = stepperAdapter
        }


    }
}