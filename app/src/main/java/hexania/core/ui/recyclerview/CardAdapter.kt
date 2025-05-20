package hexania.core.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hexania.core.R
import hexania.core.domain.model.Champion

class CardAdapter (
    val champions : MutableList<Champion>,
    val itemClickListener : CardClickListener
) :
    RecyclerView.Adapter<CardViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return CardViewHolder(view, itemClickListener, champions)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindViewItem(champions[position])

    }

    override fun getItemCount(): Int {
        return this.champions.size
    }
}