package hexania.core.vue.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import hexania.core.R
import hexania.core.model.party.PartyBuildingViewModel
import hexania.core.model.party.PartyCreationStep

class HomeScreenFragment() : Fragment() {

    private val partyViewModel : PartyBuildingViewModel by navGraphViewModels(R.id.navigation_party_builder_graph)
    private lateinit var startBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hexania_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startBtn = view.findViewById(R.id.button)
        startBtn.setOnClickListener {
            partyViewModel.reset()
            findNavController().navigate(R.id.action_homeScreen_to_detNumPlayer)
        }

    }
}