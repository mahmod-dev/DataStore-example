# DataStore-example
Preferences DataStore— It stores data in a key-value pairs like SharedPreferences but does not provide any type safety.

Full example to use preference dataStore with generic class 

We have two ways to write data into dataStore
Fisrt way:
Write data Synchronously by using runBlocking {}

Second way:
Write data Asynchronously by using lifecycleScope.launch {}

When read data from dataStore we have to use livedata to observe data when it is changed.


----------------------------------------------------------------------

Official reference:

https://developer.android.com/topic/libraries/architecture/datastore
