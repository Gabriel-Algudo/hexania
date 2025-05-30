package hexania.core

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import hexania.core.model.party.PartyBuilder
import hexania.core.model.player.PlayerBuilder



class NumPlayerActivity : AppCompatActivity() {

    lateinit var seekBar: SeekBar
    lateinit var valeurSeekBar: TextView
    lateinit var textPlayer1 : EditText
    lateinit var textPlayer2 : EditText
    lateinit var textPlayer3 : EditText
    lateinit var textPlayer4 : EditText
    lateinit var textPlayer5 : EditText
    lateinit var textPlayer6 : EditText
    lateinit var allEditText : List<EditText>
    lateinit var start_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.det_num_player)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        seekBar = findViewById(R.id.seekBar_nbJoueur)
        valeurSeekBar = findViewById(R.id.valSeekBar)
        textPlayer1 = findViewById(R.id.plainText_j1)
        textPlayer2 = findViewById(R.id.plainText_j2)
        textPlayer3 = findViewById(R.id.plainText_j3)
        textPlayer4 = findViewById(R.id.plainText_j4)
        textPlayer5 = findViewById(R.id.plainText_j5)
        textPlayer6 = findViewById(R.id.plainText_j6)
        allEditText = listOf(textPlayer1, textPlayer2, textPlayer3, textPlayer4, textPlayer5, textPlayer6)
        start_btn = findViewById(R.id.btn_start)


        seekBar.max = 6
        seekBar.min = 2
        seekBar.progress = 6
        seekBar.incrementProgressBy(1)
        valeurSeekBar.text = seekBar.progress.toString()

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                valeurSeekBar.text = progress.toString()
                for (i in allEditText.indices) {
                    if (i < progress) {
                        allEditText[i].visibility = View.VISIBLE
                    } else {
                        allEditText[i].visibility = View.GONE
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })



        start_btn.setOnClickListener {

            var party = PartyBuilder.getPartyBuilder()
            val nameList = mutableListOf<String>()

            for (editText in allEditText) {
                nameList.add(editText.text.toString())
            }

            for (numJoueur in 1..seekBar.progress) {
                var playerBuilder = PlayerBuilder.newPlayerBuilder()
                playerBuilder = playerBuilder.setName(nameList[numJoueur-1])
                //party = party.addAllPlayer(playerBuilder)
            }

            //println("######################################")
            //println(party.toString())
            //println("######################################")

            val intent : Intent = Intent(this, ChoixChampionActivity::class.java)
            intent.putExtra("party", party.toString())
            startActivity(intent)
        }
    }
}