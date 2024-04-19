package put.inf154030.szlakiturystyczne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class TrackImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_track_image, container, false)
        val trackName = (activity as TrackDetailsActivity).passToTrackImageFragment()
        val trackImage = view.findViewById<ImageView>(R.id.fragment_image_view)
        val resourceId = resources.getIdentifier(trackName.toLowerCase(), "drawable", requireContext().packageName)
        if (resourceId != 0) {
            trackImage?.setImageResource(resourceId)
        } else {
            trackImage?.setImageResource(R.drawable.placeholder_image)
        }

        return view
    }
}