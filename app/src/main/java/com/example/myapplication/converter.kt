package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentConverterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [converter.newInstance] factory method to
 * create an instance of this fragment.
 */
class converter : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var binding: FragmentConverterBinding
    private var pilihan = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConverterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalc.setOnClickListener {
            konversiMataUang()
        }

        binding.spinercalc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Log.d("converter", "pilih item: $p2")
                pilihan = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    private fun konversiMataUang() {
        val money = binding.edtbil1.text.toString().toDouble()
        val out = binding.hasilcalc
        var hasil = 0.0

        if (pilihan == 0) {
            hasil = money / 15000
        } else if (pilihan == 1) {
            hasil = money / 279.62
        } else if (pilihan == 2) {
            hasil = money / 3339.28
        } else if (pilihan == 3) {
            hasil = money / 16747.56
        }

        out.text = hasil.toString()


    }
    }