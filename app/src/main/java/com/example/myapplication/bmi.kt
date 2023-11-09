package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentBmiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [bmi.newInstance] factory method to
 * create an instance of this fragment.
 */
class bmi : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentBmiBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBmiBinding.inflate(inflater, container, false)

        binding.beratpick.minValue = 30
        binding.beratpick.maxValue = 150

        binding.tinggipick.minValue = 100
        binding.tinggipick.maxValue = 250

        binding.beratpick.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }
        binding.tinggipick.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }

        // Restore state if available
        savedInstanceState?.let {
            binding.beratpick.value = it.getInt("weight", 30)
            binding.tinggipick.value = it.getInt("height", 100)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("weight", binding.beratpick.value)
        outState.putInt("height", binding.tinggipick.value)
    }

    private fun calculateBMI() {
        val height = binding.tinggipick.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.beratpick.value
        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.healthy.text = String.format("BMI kamu adalah: %.2f", bmi)
        binding.healthy.append("\nKeterangan: " + healthyMessage(bmi))
    }

    private fun healthyMessage(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Berat badan kurang"
            bmi < 24.9 -> "Sehat"
            bmi < 29.9 -> "Kegemukan"
            else -> "Obesitas"
        }

    }
}