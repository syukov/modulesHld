package com.example.modularization.core_domain_api

interface UseCase<A, R> {
    operator fun invoke(arg: A): R
}