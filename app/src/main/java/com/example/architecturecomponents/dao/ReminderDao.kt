package com.example.architecturecomponents.dao

import androidx.room.*
import com.example.architecturecomponents.models.Reminder

@Dao
interface ReminderDao {

  @Query("SELECT * FROM reminderTable")
  suspend fun getAllReminders(): List<Reminder>

  @Insert
  suspend fun insertReminder(reminder: Reminder)

  @Delete
  suspend fun deleteReminder(reminder: Reminder)

  @Update
  suspend fun updateReminder(reminder: Reminder)

}

