package hexania.core

import android.app.Application
import android.content.Context

class Hexania : Application(){

    init{
        instance = this
    }

    companion object {
        private var instance: Hexania? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}