package com.example.modularization.domain_api_core

interface UseCase<A, R> {
    operator fun invoke(arg: A): R
}