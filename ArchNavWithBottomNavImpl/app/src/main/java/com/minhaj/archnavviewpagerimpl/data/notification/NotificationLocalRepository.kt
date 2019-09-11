package com.minhaj.archnavviewpagerimpl.data.notification

import android.media.Image
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.ThreadLocalRandom

class NotificationLocalRepository(val notificationDao: NotificationDao) {

    suspend fun getNotifications(): List<Notification> {

        val notificatios = withContext(IO){

            notificationDao.getAllNotification()
        }

        return notificatios
    }

    suspend fun addNotification(notification: Notification) : Int {

        println("before of coroutines")

        var a : Int = 0

        val returnVal = withContext(IO){
            println("before of executing query")

            a = 1
            val b = 3

            kotlinx.coroutines.delay(5000)

            notificationDao.insertNotification(notification)
        }

        println("before 'conversion to Int' courotine----$a")


        val toIntValue = withContext(Main){

            a = 2

            println("before conversion in courotine----$a")

            returnVal.toInt()
        }

        return toIntValue
    }


    suspend fun updateImage(image: String){


        val notifications =  getNotifications()

//        coroutineScope {


            withContext(IO){


                val numberMaxRange =  if (notifications.size > 0)  notifications.size else 1

                val randomInteger = ThreadLocalRandom.current().nextInt(0, numberMaxRange)

                notificationDao.updateImage(imageNew = image, imageId = notifications.get(randomInteger).id)
            }

//            launch {
//
//
//
//            }


//        }

    }



    suspend fun getCall() : Int = withContext(IO){

        kotlinx.coroutines.delay(5000)

        return@withContext 12*5
    }



    suspend fun getCallInner(it: Int, function: (number: Int) -> Unit){

        val value = withContext(IO){

            kotlinx.coroutines.delay(5000)

            return@withContext 12*5
        }

        function(value)

    }


    suspend fun getCallChildInner(): Int{

        val value = withContext(IO){

            kotlinx.coroutines.delay(5000)

            return@withContext 12*5
        }


        return value

    }

    companion object {

        @Volatile
        private var instance: NotificationLocalRepository? = null

        fun getInstance(notificationDao: NotificationDao): NotificationLocalRepository {

            return instance ?: synchronized(this) {
                instance ?: NotificationLocalRepository(notificationDao).also {
                    instance = it
                }
            }
        }

    }
}