package hexania.core.model.party

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PartyBuildingViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(PartyBuilder.newPartyBuilder())
    val uiState : StateFlow<PartyBuilderI> = _uiState.asStateFlow()

    fun advanceCreationStep(step : PartyCreationStep) {
        _uiState.update { currentState ->
            {
                when (step) {
                    PartyCreationStep.INIT -> PartyBuilder.newPartyBuilder()
                    PartyCreationStep.PLAYER -> TODO()
                    PartyCreationStep.CHAMPION -> TODO()
                    PartyCreationStep.ARME -> TODO()
                    PartyCreationStep.RELIQUE -> TODO()
                    PartyCreationStep.COMPAGNON -> TODO()
                    PartyCreationStep.ARMURE -> TODO()
                    else -> throw IllegalArgumentException("Invalid step")
                }
            } as PartyBuilderI

        }


        }
    }
