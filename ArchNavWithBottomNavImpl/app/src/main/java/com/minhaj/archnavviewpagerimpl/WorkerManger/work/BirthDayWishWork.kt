package com.minhaj.archnavviewpagerimpl.WorkerManger.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class BirthDayWishWork(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {


    override fun doWork(): Result {





        return Result.success()
    }


}