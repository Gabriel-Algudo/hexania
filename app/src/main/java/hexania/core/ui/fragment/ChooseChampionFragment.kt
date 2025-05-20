package hexania.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import hexania.core.R
import hexania.core.ui.viewmodel.NavigationEvent
import hexania.core.domain.model.Champion
import hexania.core.ui.viewmodel.PartyBuildingViewModel
import hexania.core.ui.recyclerview.CardAdapter
import hexania.core.ui.recyclerview.CardClickListener
import kotlinx.coroutines.launch
import kotlin.getValue

class ChooseChampionFragment : Fragment(), CardClickListener {

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
        recyclerView.adapter = CardAdapter(partyViewModel.pickSomeChampions(3), this)

        titre = view.findViewById(R.id.titreChoixChampion)
        titre.text = "Choisissez votre champion"


        viewLifecycleOwner.lifecycleScope.launch {
            partyViewModel.navigationEvents.collect { event ->
                when (event) {
                    NavigationEvent.toChampion -> findNavController().navigate(R.id.action_chooseChampion_to_chooseChampion)
                    //NavigationEvent.toArme -> findNavController().navigate(R.id.action_chooseChampion_to_chooseArme)
                    else -> {throw IllegalArgumentException("Invalid navigation event")}
                }
            }
        }

    }

    override fun onCardClick(champion: Champion) {
        partyViewModel.setChampionToPlayer(champion, partyViewModel.numberOfChampionsSet.value)
        partyViewModel.fromChampionToNext()
        println("############ Party actuelle : ${partyViewModel.toString()}")
    }

    /*
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)



            val indexOfPlayer = partyViewModel.indexOfPlayerShouldChooseChampion()

            titre = view.findViewById(R.id.titreChoixChampion)
            titre.text = "Choisissez votre champion"

            val champs = pickFromList(partyViewModel.championsAvailable, 3)
            recyclerView.adapter = CardAdapter(champs)

            recyclerView.setOnItemClickListener{ champion ->
                partyViewModel.championUsed.add(champion)
                partyViewModel.championsAvailable.remove(champion)

            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            partyViewModel.resetToPlayer()
        }
        */
}