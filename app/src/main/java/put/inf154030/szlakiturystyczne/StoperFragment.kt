package put.inf154030.szlakiturystyczne

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class StoperFragment : Fragment() {

    private var seconds: Int = 0
    private var running: Boolean = false
    private var wasRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
        if (Stoper.track == (activity as TrackDetailsActivity).getTrackName()) {
            seconds = Stoper.seconds
            running = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: View = inflater.inflate(R.layout.fragment_stoper, container, false)
        runStoper(layout)

        val startButton: Button = layout.findViewById(R.id.start_button)
        val stopButton: Button = layout.findViewById(R.id.stop_button)
        val resetButton: Button = layout.findViewById(R.id.reset_button)

        if (Stoper.track == "" || Stoper.track == (activity as TrackDetailsActivity).getTrackName()) {
            startButton.setOnClickListener(this::onClick)
            stopButton.setOnClickListener(this::onClick)
            resetButton.setOnClickListener(this::onClick)
        } else {
            startButton.isEnabled = false
            stopButton.isEnabled = false
            resetButton.isEnabled = false
            Toast.makeText(requireContext(), "Stoper działa na innym szlaku!", Toast.LENGTH_LONG).show()
        }

        return layout
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    private fun onClickStart() {
        Stoper.track = (activity as TrackDetailsActivity).getTrackName()
        Stoper.runningStopper = true
        Stoper.runStoper()
        running = true
    }

    private fun onClickStop() {
        Stoper.track = ""
        Stoper.seconds = 0
        Stoper.runningStopper = false
        running = false
    }

    private fun onClickReset() {
        running = false
        seconds = 0
    }

    private fun runStoper(layout: View) {
        val handler = Handler()
        val timeView: TextView = layout.findViewById(R.id.stoper_text_view)
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format("%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun onClick(view: View) {
        when (view.id) {
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
        }
    }
}