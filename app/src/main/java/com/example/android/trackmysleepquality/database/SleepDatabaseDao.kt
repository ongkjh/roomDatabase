/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SleepDatabaseDao{

    /*
    * 1. Insert new nights into daily_sleep_quality_table
    *
    * @param night new value to insert
    */
    @Insert
    suspend fun insert(night: SleepNight)

    /*
    * 2. Update an existing night with end time and quality rating
    *
    * @param night new value to update
    */
    @Update
    suspend fun update(night: SleepNight)

    /*
    * 3. Get a specific night based on keys
    *
    * @param key to get specific nights
    */
    @Query("SELECT * from daily_sleep_quality_table WHERE nightID= :key")
    suspend fun get(key: Long):SleepNight?

    /*
    * 4. Get all nights
    *
    */
    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightID DESC")
    suspend fun getGetAllNights(): LiveData<List<SleepNight>>

    /*
    * 5. Get the most recent night
    *
    */
    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightID DESC Limit 1")
    suspend fun getTonight(): SleepNight?

    /*
    * 6. Delete all entries in the database
    *
    */
    @Query("DELETE FROM daily_sleep_quality_table")
    suspend fun clear()


    // 1. Insert new nights into daily_sleep_quality_table
    // 2. Update an existing night with end time and quality rating
    // 3. Get a specific night based on keys
    // 4. Get all nights
    // 5. Get the most recent night
    // 6. Delete all entries in the database

}

