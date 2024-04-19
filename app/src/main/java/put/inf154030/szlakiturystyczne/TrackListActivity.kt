package put.inf154030.szlakiturystyczne

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import put.inf154030.szlakiturystyczne.databinding.ActivityTrackListBinding

class TrackListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackListBinding
    private var trackList = ArrayList<Tracks>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trackList = intent.getSerializableExtra("track_list") as ArrayList<Tracks>

        if (savedInstanceState == null) {
            val trackListFragment = TrackListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.track_list_container, trackListFragment)
                .commit()
        }
    }

    fun passNamesToTrackListFragment(): ArrayList<String> {
        var arr = ArrayList<String>()
        for (track in trackList) {
            arr.add(track.name)
        }
        return arr
    }

    fun passSelectedItem(trackName: String) {
        val intent = Intent(this, TrackDetailsActivity::class.java)
        intent.putExtra("track_name", trackName)
        startActivity(intent)
    }
}