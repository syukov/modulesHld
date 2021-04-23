package com.example.modularization.domain.core.api

interface UseCase<A, R> {
    operator fun invoke(arg: A): R
}