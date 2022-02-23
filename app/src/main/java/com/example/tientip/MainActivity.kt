package com.example.tientip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tientip.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTinhtien.setOnClickListener { tinhtien()  }
    }
    fun tinhtien(){
        val stringInText = binding.editTextDichVu.text.toString()
        val giaTien = stringInText.toDoubleOrNull()
        if(giaTien==null){
            binding.textViewKetQua.text = ""
            return
        }
        val selectButton = binding.groupButton.checkedRadioButtonId
        val phanTram = when(selectButton){
            R.id.button_amazing -> 0.20
            R.id.button_good -> 0.18
            else -> 0.15
        }
        var tip = phanTram * giaTien
        val lamTron = binding.switch1.isChecked
        if(lamTron){
            tip = kotlin.math.ceil(tip)
        }
        val formatTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.textViewKetQua.text = getString(R.string.ketqua, formatTip)
    }
}