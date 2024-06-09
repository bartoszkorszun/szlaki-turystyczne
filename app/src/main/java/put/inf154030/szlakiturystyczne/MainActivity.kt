package put.inf154030.szlakiturystyczne

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import put.inf154030.szlakiturystyczne.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val easyTracks = binding.easyTracksCardView
        val hardTracks = binding.hardTracksCardView

        easyTracks?.setOnClickListener() {
            val intent = Intent(this, TrackListActivity::class.java)
            intent.putExtra("track_list", Tracks.getTrackList("easy"))
            startActivity(intent)
        }

        hardTracks?.setOnClickListener() {
            val intent = Intent(this, TrackListActivity::class.java)
            intent.putExtra("track_list", Tracks.getTrackList("hard"))
            startActivity(intent)
        }

        if (savedInstanceState == null) {
            Tracks.createTrackList(this)
            supportFragmentManager.beginTransaction()
                .replace(R.id.tool_bar_fragment, MenuFragment())
                .commit()
        }
    }
}