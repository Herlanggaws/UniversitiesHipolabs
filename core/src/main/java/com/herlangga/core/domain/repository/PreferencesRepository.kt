package com.herlangga.core.domain.repository

interface PreferencesRepository {
    suspend fun getString(key: String): String?
    suspend fun setString(key: String, value: String)
    suspend fun removeString(vararg key: String)
    suspend fun getBoolean(key: String): Boolean?
    suspend fun setBoolean(key: String, value: Boolean)
    suspend fun removeBoolean(vararg key: String)
    suspend fun getLong(key: String): Long?
    suspend fun setLong(key: String, value: Long)
    suspend fun removeLong(vararg key: String)
    suspend fun clear()
}
