package hexania.core.ui.viewmodel

sealed class NavigationEvent{
    object toInit : NavigationEvent()
    object toPlayer : NavigationEvent()
    object toChampion : NavigationEvent()
    object toArme : NavigationEvent()
}