package put.inf154030.szlakiturystyczne

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import put.inf154030.szlakiturystyczne.databinding.ActivityTrackDetailsBinding

class TrackDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackDetailsBinding
    private var trackName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrackDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trackName = intent.getStringExtra("track_name").toString()
        println(trackName)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.tool_bar_fragment, MenuFragment())
                .add(R.id.track_image_container, TrackImageFragment())
                .add(R.id.track_details_container, TrackDetailsFragment())
                .add(R.id.stoper_container, StoperFragment())
                .commit()
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener() {view ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:")
            intent.putExtra("sms_body", "Gorące pozdrowienia, właśnie odkrywam szlak $trackName")
            startActivity(intent)
        }
    }

    fun passToTrackDetailsFragment(): String {
        return Tracks.getTrackDescription(trackName)
    }

    fun passToTrackImageFragment(): String {
        return intent.getStringExtra("track_name").toString()
    }

    fun getTrackName(): String {
        return trackName
    }
}