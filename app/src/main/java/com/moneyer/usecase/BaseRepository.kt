package com.moneyer.usecase

open class BaseRepository {

    suspend fun<T> safeCall(block: suspend () -> T) : Result<T>{
        return try {
            val response = block.invoke()
            Result.success(response)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}