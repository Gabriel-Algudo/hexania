package hexania.core.vue.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hexania.core.R
import hexania.core.model.character.Champion
import hexania.core.vue.recyclerview.CardViewHolder

class CardAdapter (val champions : MutableList<Champion>) : RecyclerView.Adapter<CardViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindViewItem(champions[position])
    }

    override fun getItemCount(): Int {
        return this.champions.size
    }
}