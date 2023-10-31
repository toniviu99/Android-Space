package com.example.spaceapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.spaceapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels <MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.getPictures("2023-10-25", "PoNptxjSfY3ZKGG0AWcJZ8Qdk5vFXDed36Jgajeu")
        initUI()
    }
    private fun initUI(){
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.state.collect {
                    when(it){
                        MainState.Loading -> loadingState()
                        is MainState.Error -> errorState()
                        is MainState.Success -> successState(it)
                    }
                }
            }
        }
    }
    private fun loadingState(){
        binding.pb.isVisible = true
    }
    private fun errorState(){
        binding.pb.isVisible = false
        Toast.makeText(this,"error",Toast.LENGTH_LONG).show()

    }
    private fun successState(mainState: MainState.Success) {
        binding.pb.isVisible = false
        Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
        Log.d("toni",mainState.toString())
    }
}