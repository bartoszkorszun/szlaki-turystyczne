package put.inf154030.szlakiturystyczne

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.io.Serializable

class Tracks(var name: String, var difficulty: String, var description: String) : Serializable {

    companion object {
        val tracks = ArrayList<Tracks>()

        fun createTrackList(context: Context) {
            val inputStream = context.assets.open("TrackList.json")
            val reader = InputStreamReader(inputStream)
            val listType = object : TypeToken<ArrayList<Tracks>>() {}.type
            tracks.addAll(Gson().fromJson(reader, listType))
            reader.close()
        }

        fun getTrackDescription(trackName: String): String {
            for (track in tracks) {
                if (track.name == trackName) {
                    return track.description
                }
            }
            return "Brak opisu"
        }

        fun getTrackList(diff: String): ArrayList<Tracks> {
            val arr = ArrayList<Tracks>()
            for (track in tracks) {
                if (track.difficulty == diff) {
                    arr.add(track)
                }
            }
            return arr
        }
    }
}