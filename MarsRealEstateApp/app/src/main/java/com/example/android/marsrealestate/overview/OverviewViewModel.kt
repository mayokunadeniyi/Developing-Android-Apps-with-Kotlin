/*
 * Copyright 2018, The Android Open Source Project
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
 *
 */

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.marsrealestate.network.MarsApi
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _status

    //Just the first response from the API
    private val _property = MutableLiveData<MarsProperty>()

    //The external immutable LiveData for the request status String
    val property: LiveData<MarsProperty>
    get() = _property

    //Coroutine Job and Coroutine Scope
    val coroutineJob = Job()
    val coroutineScope = CoroutineScope(Dispatchers.Main + coroutineJob)

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {
      coroutineScope.launch {
          val getPropertiesDeferred = MarsApi.retrofitService.getProperties()
          try {
             // _status.value = "Success ${getPropertiesDeferred.size} Mars properties retrieved"
              if (getPropertiesDeferred.size > 0){
                  _property.value = getPropertiesDeferred[0]
              }
          }catch (t: Throwable){
              _status.value = "Failure" + t.message
          }
      }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineJob.cancel()
    }
}
