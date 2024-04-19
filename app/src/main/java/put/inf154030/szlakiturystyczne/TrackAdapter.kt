package put.inf154030.szlakiturystyczne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrackAdapter(
    private val trackNames: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(trackNames[position])
    }

    override fun getItemCount(): Int {
        return trackNames.size
    }

    inner class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val trackNameTextView: TextView = itemView.findViewById(R.id.track_name)
        private val trackImageView: ImageView = itemView.findViewById(R.id.track_image)

        fun bind(trackName: String) {
            trackNameTextView.text = trackName
            val resourceId = itemView.context.resources.getIdentifier(trackName.toLowerCase(), "drawable", itemView.context.packageName)
            if (resourceId != 0) {
                trackImageView.setImageResource(resourceId)
            } else {
                trackImageView.setImageResource(R.drawable.placeholder_image)
            }

            itemView.setOnClickListener {
                onItemClick(trackName)
            }
        }
    }

}


