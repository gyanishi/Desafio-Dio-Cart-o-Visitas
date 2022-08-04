package com.gyanishi.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gyanishi.businesscard.App
import com.gyanishi.businesscard.R
import com.gyanishi.businesscard.data.BussinessCard
import com.gyanishi.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBusinessCardBinding

    private val MainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnAdd.setOnClickListener {
            val bussinessCards = BussinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            MainViewModel.insert(bussinessCards)
            Toast.makeText(this, R.string.txtShowSucess, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}