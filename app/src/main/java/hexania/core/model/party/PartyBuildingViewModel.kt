package hexania.core.model.party

import androidx.lifecycle.ViewModel
import hexania.core.model.player.Player
import hexania.core.model.player.PlayerBuilderI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PartyBuildingViewModel : ViewModel() {

    private var nextStep : PartyCreationStep = PartyCreationStep.INIT
    private var _uiState = MutableStateFlow(PartyBuilder.getPartyBuilder())
    val uiState : StateFlow<PartyBuilderI> = _uiState.asStateFlow()

    fun reset (){
        if (this.nextStep == PartyCreationStep.INIT){
            _uiState.value.reset()
            this.nextStep = PartyCreationStep.PLAYER
        }
    }

    fun stepInitToPlayer(players : MutableList<PlayerBuilderI>) {
    if (this.nextStep == PartyCreationStep.PLAYER){
            _uiState.value.addAllPlayer(players)
        this.nextStep = PartyCreationStep.CHAMPION
        } else {
            throw IllegalArgumentException("Invalid step")
        }
    }

    fun stepPlayerToChampion(nextStep : PartyCreationStep, champions : Player) {
        TODO()
    }

    }
