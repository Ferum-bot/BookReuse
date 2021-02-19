package com.github.ferum_bot.bookreuse.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.ActivityMainBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:13
 * Project: BookReuse
 */
class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setContentView(binding.root)
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

}