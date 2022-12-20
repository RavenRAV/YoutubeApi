package com.example.youtubeparcer.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding
//        , VM: BaseViewModel
        > : AppCompatActivity(){
    protected lateinit var binding: VB
//    protected lateinit var viewModel: VM
    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        initView()
        initObservers()
        initListener()
    }

    abstract fun checkInternet()

    abstract fun initView()

    abstract fun initObservers()

    abstract fun initListener()
}