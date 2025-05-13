package hexania.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import hexania.core.R
import hexania.core.model.character.Champion
import hexania.core.model.party.PartyBuildingViewModel
import hexania.core.ui.recyclerview.CardAdapter
import kotlin.getValue

class ChooseChampionFragment : Fragment() {

    //variable stockant les parametres pour la construction d'une Party
    private val partyViewModel : PartyBuildingViewModel by navGraphViewModels(R.id.navigation_party_builder_graph)

    //ui
    lateinit var recyclerView : RecyclerView
    lateinit var titre : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choix_champion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        val champions = Champion.getAllCharacters(requireContext())

        titre = view.findViewById(R.id.titreChoixChampion)
        titre.text = "Choisissez votre champion"

        recyclerView.adapter = CardAdapter(champions)
    }

    private fun pickFromList(champions : MutableList<Champion>, number : Int) : MutableList<Champion>{
        val champs = mutableListOf<Champion>()
        for (i in 1..number){
            val alea = (0..champions.size).random()
            champs.add(champions[alea])
        }
        return champs
    }

    override fun onDestroyView() {
        super.onDestroyView()
        partyViewModel.resetToPlayer()
    }
}