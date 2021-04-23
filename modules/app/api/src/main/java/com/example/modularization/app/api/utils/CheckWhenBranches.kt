package com.example.modularization.core_feature.utils

/**
 * This extension is used to be sure that all branches of "when" block are handled.
 * if "when" block does not handle all branches then it does not return anything and there is no way to call [checkWhenBranches] on it.
 */
val <T> T.checkWhenBranches: T
    get() = this