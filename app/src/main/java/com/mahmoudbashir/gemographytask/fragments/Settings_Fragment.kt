package com.mahmoudbashir.gemographytask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.gemographytask.R
import com.mahmoudbashir.gemographytask.databinding.FragmentSettingsBinding

class Settings_Fragment : Fragment() {

    lateinit var settingsBinding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        settingsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_settings, container, false)


        return settingsBinding.root
    }
}