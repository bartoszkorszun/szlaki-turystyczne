package put.inf154030.szlakiturystyczne

import android.os.Handler

object Stoper {
    var track: String = ""
    var seconds: Int = 0
    var runningStopper: Boolean = false

    fun runStoper() {
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                if (runningStopper) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}