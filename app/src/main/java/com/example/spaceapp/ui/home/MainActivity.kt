package com.example.spaceapp.ui.home

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spaceapp.databinding.ActivityMainBinding
import com.example.spaceapp.ui.home.adapter.PictureAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels <MainViewModel>()
    private lateinit var adapter:PictureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }
    private fun initUI(){
        initStartDate()
        initRecyclerView()
        initUIState()
    }

    private fun initRecyclerView() {
        adapter = PictureAdapter(onItemSelected = {
            Toast.makeText(this,it.title.toString() , Toast.LENGTH_LONG).show()
//            findNavController().navigate(
//
//            )
        })
        binding.rvPictures.layoutManager = LinearLayoutManager(this)
        binding.rvPictures.adapter = adapter
    }

    private fun initStartDate() {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val current = formatter.format(date)
        var startDate = current.toString().subSequence(0,8).toString()
        startDate += "01"
        mainViewModel.getPictures(startDate, "PoNptxjSfY3ZKGG0AWcJZ8Qdk5vFXDed36Jgajeu")
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
    private fun successState(state: MainState.Success) {
        binding.pb.isVisible = false
        adapter.updateList(state.predictionModel.info)
        Log.d("toni",state.toString())
    }

}