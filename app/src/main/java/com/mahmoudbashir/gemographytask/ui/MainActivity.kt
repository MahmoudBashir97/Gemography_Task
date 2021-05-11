package com.mahmoudbashir.gemographytask.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mahmoudbashir.gemographytask.R
import com.mahmoudbashir.gemographytask.databinding.ActivityMainBinding
import com.mahmoudbashir.gemographytask.repository.Repository
import com.mahmoudbashir.gemographytask.viewModel.TrendingViewModel
import com.mahmoudbashir.gemographytask.viewModel.TrendingViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : TrendingViewModel
    lateinit var actBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val repo = Repository()
        val trendingViewProvider = TrendingViewModelProviderFactory(application,repo)

        viewModel = ViewModelProvider(this,trendingViewProvider).get(TrendingViewModel::class.java)
        window.statusBarColor = Color.WHITE
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment

        actBinding.bottomNav.setupWithNavController(navHostFrag.findNavController())
    }
}