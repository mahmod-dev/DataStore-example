package com.mahmouddev.datastoreexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.mahmouddev.datastoreexample.datastore.DataStoreRef
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var dataStoreRef: DataStoreRef
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataStoreRef = DataStoreRef(this)

        // use your preferred way to write data:
        //first way:
        writeToDataStoreSynchronously()

        //second way:
        writeToDataStoreAsynchronously()


        // to read data from data store
        readDataStoreAsLifeData()
    }

    private fun writeToDataStoreSynchronously() {

        runBlocking {
            // write data as key&value
            dataStoreRef.setString("name", "mahmoud")
            dataStoreRef.setInt("age", 23)
            dataStoreRef.setBoolean("isGraduated", true)
            dataStoreRef.setFloat("average", 92.5F)
            dataStoreRef.setLong("salary", 5000L)
        }
    }

    private fun writeToDataStoreAsynchronously() {

        lifecycleScope.launch {
            // write data as key&value
            dataStoreRef.setString("name", "Mahmoud")
            dataStoreRef.setInt("age", 23)
            dataStoreRef.setBoolean("isGraduated", true)
            dataStoreRef.setFloat("average", 92.5F)
            dataStoreRef.setLong("salary", 5000L)
        }

    }

    private fun readDataStoreAsLifeData(){

        dataStoreRef.getString("name").asLiveData().observe(this, Observer {
            Log.d(TAG, "name: $it")
        })

        dataStoreRef.getInt("age").asLiveData().observe(this, Observer {
            Log.d(TAG, "age: $it")
        })

        dataStoreRef.getBoolean("isGraduated").asLiveData().observe(this, Observer {
            Log.d(TAG, "isGraduated: $it")
        })

        dataStoreRef.getFloat("average").asLiveData().observe(this, Observer {
            Log.d(TAG, "average: $it")
        })

        dataStoreRef.getLong("salary").asLiveData().observe(this, Observer {
            Log.d(TAG, "salary: $it")
        })
    }

}