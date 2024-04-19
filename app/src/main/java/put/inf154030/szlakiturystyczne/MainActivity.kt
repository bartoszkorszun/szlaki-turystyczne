package put.inf154030.szlakiturystyczne

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import put.inf154030.szlakiturystyczne.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private var trackName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Tracks.createTrackList(this)

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
//        if (findViewById<View>(R.id.track_details_container_large) != null) {
//            if (savedInstanceState == null) {
//                Tracks.createTrackList(this)
//                val trackListFragment = TrackListFragment()
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.track_list_container_large, trackListFragment)
//                    .add(R.id.track_details_container_large, TrackDetailsFragment())
//                    .commit()
//            } else {
//                trackName = savedInstanceState.getString("track_name").toString()
//            }
//        } else {
//            if (savedInstanceState == null) {
//                Tracks.createTrackList(this)
//                val trackListFragment = TrackListFragment()
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.track_list_container, trackListFragment)
//                    .commit()
//            }
//        }
    }

//    fun passSelectedItem(trackName: String) {
//
//        if (findViewById<View>(R.id.track_details_container_large) == null) {
//            val intent = Intent(this, TrackDetailsActivity::class.java)
//            intent.putExtra("track_name", trackName)
//            startActivity(intent)
//        } else {
//            this.trackName = trackName
//            val trackDetailsFragment = TrackDetailsFragment()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.track_details_container_large, trackDetailsFragment)
//                .replace(R.id.stoper_container_large, StoperFragment())
//                .commit()
//        }
//    }

//    fun passToTrackDetailsFragment(): String {
//        return Tracks.getTrackDescription(trackName)
//    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("track_name", trackName)
//    }
}