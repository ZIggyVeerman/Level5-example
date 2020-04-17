package com.example.architecturecomponents.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architecturecomponents.models.Reminder
import com.example.architecturecomponents.ReminderRoomDatabase
import com.example.architecturecomponents.dao.ReminderDao

class ReminderRepository(context: Context) {
  private var reminderDao: ReminderDao?

  init {
    val reminderRoomDatabase = ReminderRoomDatabase.getReminderRoomDatabase(context)
    reminderDao = reminderRoomDatabase?.reminderDao()
  }

  fun getAllReminders(): LiveData<List<Reminder>> {
    return reminderDao?.getAllReminders() ?: MutableLiveData(emptyList())
  }

  suspend fun insertReminder(reminder: Reminder) {
    reminderDao?.insertReminder(reminder)
  }

  suspend fun deleteReminder(reminder: Reminder) {
    reminderDao?.deleteReminder(reminder)
  }

  suspend fun updateReminder(reminder: Reminder) {
    reminderDao?.updateReminder(reminder)
  }
}
