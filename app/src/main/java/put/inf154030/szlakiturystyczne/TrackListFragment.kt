package put.inf154030.szlakiturystyczne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrackListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_track_list, container, false)

        val trackNames = (activity as TrackListActivity).passNamesToTrackListFragment()

        val trackList = view.findViewById<RecyclerView>(R.id.track_list)
        trackList.layoutManager = LinearLayoutManager(requireContext())
        trackList.adapter = TrackAdapter(trackNames) {trackName ->
            (activity as TrackListActivity).passSelectedItem(trackName)
        }

        return view
    }
}