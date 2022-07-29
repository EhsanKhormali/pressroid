package ir.schooltech.carousel

import android.os.Handler
import android.os.Looper
import java.util.*

class LoopHandler(
    private val delay: Long,
    private val period: Long,
    private val onLoop: () -> Unit ) {
    private var timer: Timer? = null
    private var periodicTimerTask: TimerTask? = null

    /** Starts the periodic task. */
     fun startAutoLooping() {
        timer?.cancel()
        periodicTimerTask?.cancel()

        timer = Timer()
        periodicTimerTask = PeriodicTimerTask()
        timer?.scheduleAtFixedRate(periodicTimerTask, delay, period)
    }

    /** Stops the periodic task. */
     fun stopAutoLooping() {
        timer?.cancel()
        periodicTimerTask?.cancel()
    }

    private inner class PeriodicTimerTask : TimerTask() {
        override fun run() {
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.post {
                onLoop()
            }
        }
    }
}