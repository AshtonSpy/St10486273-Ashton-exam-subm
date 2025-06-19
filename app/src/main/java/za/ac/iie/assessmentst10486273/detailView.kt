package za.ac.iie.assessmentst10486273

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailView : AppCompatActivity() {

    private lateinit var songList: ArrayList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailText = findViewById<TextView>(R.id.txtDetails)
        val avgText = findViewById<TextView>(R.id.txtAverage)
        val returnBtn = findViewById<Button>(R.id.btnReturn)
        val calcAvgBtn = findViewById<Button>(R.id.btnCalcAverage)
        val showSongsBtn = findViewById<Button>(R.id.btnShowSongs)

        songList = intent.getParcelableArrayListExtra("songs") ?: arrayListOf()

        showSongsBtn.setOnClickListener {
            detailText.text = ""
            for (song in songList)
                detailText?.append("Title: ${song.title}\nArtist: ${song.artist}\nRating: ${song.rating}\nComment: ${song.comment}\n\n")

            calcAvgBtn.setOnClickListener {
                if (songList.isNotEmpty()) {
                    val total = songList.sumOf { it.rating.toIntOrNull()?:0 }
                    val avg = total.toDouble() / songList.size
                    avgText.text = "average rating :%2f".format(avg)

                    returnBtn.setOnClickListener {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                    }
                }
            }
        }
    }
}












