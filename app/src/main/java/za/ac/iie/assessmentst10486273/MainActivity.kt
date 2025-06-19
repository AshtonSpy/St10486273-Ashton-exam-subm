package za.ac.iie.assessmentst10486273

//St10486273
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

private val songs =ArrayList<Song>()

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val titleInput = findViewById<EditText>(R.id.songTitleInput)
    val artistInput = findViewById<EditText>(R.id.artistInput)
    val ratingInput = findViewById<EditText>(R.id.ratingInput)
    val commentInput = findViewById<EditText>(R.id.commentInput)
    val addButton = findViewById<Button>(R.id.btnAdd)
    val viewButton = findViewById<Button>(R.id.btnView)
    val exitButton = findViewById<Button>(R.id.btnExit)

    addButton.setOnClickListener {
        val song = Song(
            titleInput.text.toString(),
            artistInput.text.toString(),
            ratingInput.text.toString(),
            commentInput.text.toString()

        )
        if (songs.size < 4) {
            songs.add(song)
            Toast.makeText(this, "Song Added to List!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Playlist is full(Only 4 songs)", Toast.LENGTH_SHORT).show()
        }
    }


    viewButton.setOnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        intent.putParcelableArrayListExtra("songs", songs)
        startActivity(intent)

    }
    exitButton.setOnClickListener {
        finish()
    }
}
}














