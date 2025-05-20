package hexania.core.ui.recyclerview

import hexania.core.domain.model.Champion

interface CardClickListener {
    fun onCardClick(champion : Champion)
}