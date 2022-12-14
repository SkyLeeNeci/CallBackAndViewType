package test.karpenko.callbackandviewtype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import test.karpenko.callbackandviewtype.models.Animal

class AnimalsAdapter : RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder>() {

    var animalsList = arrayListOf<Animal>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var onAnimalClick: OnAnimalClick? = null

    fun setCallback(onAnimalClick: OnAnimalClick){
        this.onAnimalClick = onAnimalClick
    }

    inner class AnimalsViewHolder(private val itemView: View, onAnimalClick: OnAnimalClick?): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.animalName)
        val btnAnimalVoice = itemView.findViewById<Button>(R.id.btnAnimalVoice)
        val animal_cl = itemView.findViewById<ConstraintLayout>(R.id.item_animal_cl)
        init {
            btnAnimalVoice.setOnClickListener {
                onAnimalClick?.onAnimalClickExclamationListener(animalsList[adapterPosition])
            }
            /*animal_cl.setOnClickListener {
                onAnimalClick?.onAnimalClickExclamationListener(animalsList[adapterPosition])
            }*/
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = animalsList[position]
        return if (item.isFlying){
            VIEW_TYPE_ENABLED
        }else{
            VIEW_TYPE_DISABLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        return if (viewType == VIEW_TYPE_ENABLED){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal_flying, parent, false)
            AnimalsViewHolder(view, onAnimalClick)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal_not_flying, parent, false)
            AnimalsViewHolder(view, onAnimalClick)
        }
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        val animal = animalsList[position]

       /* holder.itemView.setOnClickListener {
            onAnimalClick?.onAnimalClickExclamationListener(animal)
        }
*/
        if (animal.isFlying){
            with(holder) {
                 name.text = animal.name
            }
        }else{
            with(holder) {
                name.text = animal.name
            }
        }
    }

    override fun getItemCount() = animalsList.size


    companion object{
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLE = 0
        const val MAX_POOL_SIZE = 20
    }

}