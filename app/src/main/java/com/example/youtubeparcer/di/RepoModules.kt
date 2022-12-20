package com.example.youtubeparcer.di

import com.example.youtubeparcer.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules: Module = module {
    single { Repository(get()) }
}