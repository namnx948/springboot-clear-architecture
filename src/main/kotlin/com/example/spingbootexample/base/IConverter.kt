package com.example.spingbootexample.base

/**
 * Convert Data from INPUT
 * and result OUTPUT
 */
interface IConverter<I, O> {
    fun convert(input: I): O
}