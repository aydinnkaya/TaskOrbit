package com.aydinkaya.taskorbit.viewmodel.other

import android.content.Context

class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    fun saveUserId(userId: Long) {
        prefs.edit().putLong("user_id", userId).apply()
    }

    fun getUserId(): Long {
        return prefs.getLong("user_id", -1L)
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
