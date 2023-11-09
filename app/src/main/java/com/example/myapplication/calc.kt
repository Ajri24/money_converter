package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentCalcBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [calc.newInstance] factory method to
 * create an instance of this fragment.
 */
class calc : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentCalcBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalcBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pilihan = 0

        var gEdt1 = binding.edtbil1
        var gEdt2 = binding.edtbil2
        var gSpin = binding.spinercalc
        var GbtnCal = binding.btnCalc
        var gTvHasil = binding.hasilcalc

        binding.btnCalc.setOnClickListener {
            var nilai1 = gEdt1.text.toString().toDouble()
            var nilai2 = gEdt2.text.toString().toDouble()
            var hasil = 0.0

            Log.d("alif", "nilai1" + nilai1 +
                    ", nilai 2:" + nilai2)

            if (pilihan.equals(0)){
                hasil = nilai1 + nilai2
            }
            else if (pilihan.equals(1)){
                hasil = nilai1 - nilai2
            }
            else if (pilihan.equals(2)){
                hasil = nilai1 * nilai2
            }
            else if (pilihan.equals(3)){
                hasil = nilai1 / nilai2
            }

            gTvHasil.text = hasil.toString()
        }
        gSpin.setOnItemSelectedListener(

            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Log.d("Ajri","pilih item:" + p2)
                    pilihan = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
              })
    }
}