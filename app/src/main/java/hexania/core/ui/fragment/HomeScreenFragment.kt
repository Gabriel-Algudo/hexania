package hexania.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import hexania.core.R
import hexania.core.ui.viewmodel.NavigationEvent
import hexania.core.ui.viewmodel.PartyBuildingViewModel
import kotlinx.coroutines.launch

class HomeScreenFragment() : Fragment() {

    private val partyViewModel : PartyBuildingViewModel by navGraphViewModels(R.id.navigation_party_builder_graph)

    //Element de l'UI
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

        //partyViewModel.reset()

        startBtn = view.findViewById(R.id.button)
        startBtn.setOnClickListener {
            partyViewModel.toPlayer()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            partyViewModel.navigationEvents.collect { event ->
                when (event) {
                    NavigationEvent.toPlayer -> findNavController().navigate(R.id.action_homeScreen_to_detNumPlayer)
                    else -> {throw IllegalArgumentException("Invalid navigation event")}
                }
            }
        }
    }
}