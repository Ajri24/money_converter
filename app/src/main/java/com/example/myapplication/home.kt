package com.example.myapplication

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        var profile = binding.profile



        profile.setOnClickListener {
            val intent = Intent(requireContext(), profile::class.java)
            startActivity(intent)
            Log.d("Ajri","pilih item:" + intent)
        }


        val view = binding.root
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.profile.setOnClickListener {
            logout()
        }
    }
    private fun logout(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Attention")
        builder.setMessage("Yakin Ingin Logout ?")

        builder.setPositiveButton(android.R.string.yes){dialog, which ->
            Toast.makeText(requireContext(), android.R.string.yes, Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(),login::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton(android.R.string.no){dialog, which ->
            Toast.makeText(requireContext(), android.R.string.no, Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.show()
        }



}