package com.danilkharytonov.core.base

interface Mapper<T, R> {
    fun map(entity: T) : R
}