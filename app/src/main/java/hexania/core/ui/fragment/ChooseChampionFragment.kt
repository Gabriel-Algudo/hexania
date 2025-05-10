package hexania.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import hexania.core.R
import hexania.core.model.character.Champion
import hexania.core.model.party.PartyBuildingViewModel
import hexania.core.ui.recyclerview.CardAdapter
import kotlin.getValue

class ChooseChampionFragment : Fragment() {

    private val partyViewModel : PartyBuildingViewModel by navGraphViewModels(R.id.navigation_party_builder_graph)

    lateinit var recyclerView : RecyclerView

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

        recyclerView.adapter = CardAdapter(champions)

    }
}