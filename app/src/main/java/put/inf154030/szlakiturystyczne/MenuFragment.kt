package put.inf154030.szlakiturystyczne

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val home = view.findViewById<Button>(R.id.home)
        val trudne = view.findViewById<Button>(R.id.trudne)
        val latwe = view.findViewById<Button>(R.id.latwe)

        home.setOnClickListener{
            if (activity !is MainActivity){
                val intent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(intent)
            }
        }
        latwe.setOnClickListener{
            val intent = Intent(requireActivity(), TrackListActivity::class.java)
            intent.putExtra("track_list", Tracks.getTrackList("easy"))
            startActivity(intent)
        }
        trudne.setOnClickListener{
            val intent = Intent(requireActivity(), TrackListActivity::class.java)
            intent.putExtra("track_list", Tracks.getTrackList("hard"))
            startActivity(intent)
        }

        return view
    }
}