package com.example.youtubeparcer.di

import com.example.youtubeparcer.core.network.networkModule
import org.koin.core.module.Module

val koinModules = listOf<Module>(
    repoModules,
    viewModules,
    networkModule
)