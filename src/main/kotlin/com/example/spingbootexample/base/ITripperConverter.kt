package com.example.spingbootexample.base

interface ITripperConverter<I, W, O> {
    fun convert(input: I, source: W): O
}