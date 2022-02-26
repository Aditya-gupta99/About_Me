package com.sparklead.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.sparklead.aboutme.R
import com.sparklead.aboutme.databinding.ActivityMainBinding
import com.sparklead.aboutme.MyName

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Aditya Gupta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.donebutton).setOnClickListener {
//            addnickname(it)
//        }

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        binding.myName = myName

        binding.donebutton.setOnClickListener {
            addnickname(it)
        }

    }

    private fun addnickname(view: View)
    {

//        binding.nicknametextview.text = binding.nicknameeditview.text

        binding.myName?.nickname = binding.nicknameeditview.text.toString()
        binding.invalidateAll()
        binding.nicknameeditview.visibility = View.GONE
        binding.donebutton.visibility = View.GONE
        binding.nicknametextview.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
