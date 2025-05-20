package hexania.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hexania.core.data.builder.PartyBuilder
import hexania.core.data.builder.PartyBuilderI
import hexania.core.domain.model.Champion
import hexania.core.ui.viewmodel.NavigationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PartyBuildingViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PartyBuilder.Companion.getPartyBuilder())
    val uiState : StateFlow<PartyBuilderI> = _uiState.asStateFlow()

    private val _navigationEvents = Channel<NavigationEvent>(Channel.Factory.BUFFERED)
    // expose un Flow public pour être observé
    val navigationEvents = _navigationEvents.receiveAsFlow()

    private val _championsAvailable = MutableStateFlow<List<Champion>>(emptyList()) // Start empty
    val numberOfChampionsSet = MutableStateFlow(0)
    val championsAvailable: StateFlow<List<Champion>> = _championsAvailable.asStateFlow()

    init {
        try {
            _championsAvailable.value = Champion.getAllCharacters()
        } catch (e : Exception) {
            throw e
        }
    }

    fun toPlayer () {
        viewModelScope.launch {
            _navigationEvents.send(NavigationEvent.toPlayer)
        }
    }
    fun addPlayer(){
        _uiState.value.addPlayer()
    }

    fun addNameToPlayer(name: String, index: Int){
        _uiState.value.setNameToPlayer(name, index)
    }

    fun toChampion (){
        viewModelScope.launch {
            _navigationEvents.send(NavigationEvent.toChampion)
        }
    }

    fun pickSomeChampions(number : Int) : MutableList<Champion>{
        val champs = mutableListOf<Champion>()
        while (champs.size < number){
            val alea = (0.._championsAvailable.value.size -1).random()
            champs.add(_championsAvailable.value[alea])
        }
        return champs
    }

    fun setChampionToPlayer(champion : Champion, index :Int){
        _uiState.value.setChampionToPlayer(champion, index)
        _championsAvailable.value = _championsAvailable.value.filter { it != champion }
        numberOfChampionsSet.value++
    }

    fun fromChampionToNext(){
        if (numberOfChampionsSet.value < uiState.value.getAllPlayer().size){
            toChampion()
        } else {
            toArme()
        }
    }

    fun toArme() {
        viewModelScope.launch {
            _navigationEvents.send(NavigationEvent.toArme)
        }
    }

    override fun toString(): String {
        return _uiState.value.toString()
    }



/*
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

    fun resetToPlayer(){
        this.nextStep = PartyCreationStep.PLAYER
    }

    fun resetToInit(){
        this.nextStep = PartyCreationStep.INIT
    }
*/
    }