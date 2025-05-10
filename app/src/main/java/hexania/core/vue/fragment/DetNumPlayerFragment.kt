package hexania.core.vue.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import hexania.core.R
import hexania.core.model.party.PartyBuildingViewModel
import kotlin.getValue


class DetNumPlayerFragment() : Fragment(){

    private val partyViewModel : PartyBuildingViewModel by navGraphViewModels(R.id.navigation_party_builder_graph)

    //variable de l'UI
    lateinit var seekBar: SeekBar
    lateinit var valeurSeekBar: TextView
    lateinit var allEditText : List<EditText>
    lateinit var startBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.det_num_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seekBar = view.findViewById(R.id.seekBar_nbJoueur)
        valeurSeekBar = view.findViewById(R.id.valSeekBar)
        val textPlayer1 = view.findViewById<EditText>(R.id.plainText_j1)
        val textPlayer2 = view.findViewById<EditText>(R.id.plainText_j2)
        val textPlayer3 = view.findViewById<EditText>(R.id.plainText_j3)
        val textPlayer4 = view.findViewById<EditText>(R.id.plainText_j4)
        val textPlayer5 = view.findViewById<EditText>(R.id.plainText_j5)
        val textPlayer6 = view.findViewById<EditText>(R.id.plainText_j6)
        allEditText = listOf(textPlayer1, textPlayer2, textPlayer3, textPlayer4, textPlayer5, textPlayer6)
        startBtn = view.findViewById(R.id.btn_start)

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

        startBtn.setOnClickListener {
            var nameList = mutableListOf<String>()
            for (editText in allEditText) {
                nameList.add(editText.text.toString())
            }
            //partyViewModel.stepInitToPlayer(nameList)
        }
    }
}
