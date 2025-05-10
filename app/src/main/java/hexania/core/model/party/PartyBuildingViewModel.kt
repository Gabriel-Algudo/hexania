package hexania.core.model.party

import androidx.lifecycle.ViewModel
import hexania.core.model.player.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

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

    fun stepInitToPlayer(playersName : MutableList<String>) {
    if (this.nextStep == PartyCreationStep.PLAYER){
            _uiState.value.addAllPlayer(playersName)
        this.nextStep = PartyCreationStep.CHAMPION
        } else {
            throw IllegalArgumentException("Invalid step")
        }
    }

    fun stepPlayerToChampion(nextStep : PartyCreationStep, champions : Player) {
        TODO()
    }

    }
