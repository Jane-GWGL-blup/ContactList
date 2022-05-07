package com.caceres.contactlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.caceres.contactlist.databinding.ItemContactBinding
import com.caceres.contactlist.model.Song

class ContactsAdapter(private val dataSet: List<Song>):
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    /**
     * Proporciona una referencia al tipo de vistas que está utilizando
     * (custom ViewHolder).
     */
    class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var name: TextView = binding.tvNameSong
        var info: TextView = binding.tvInfo
        var additionalText: TextView = binding.aditionalText
        var imgRock: ImageView = binding.imgRock
        var checkFavorite: CheckBox = binding.chkFavorite
        var btnPlay: ImageButton = binding.btnPlay
        var btnPause: ImageButton = binding.btnStop
        var btnShare: ImageButton = binding.btnShare
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Crear una nueva vista, que define la interfaz de usuario del elemento de la lista
        val itemBinding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    // Reemplazar el contenido de una vista (invocado por el administrador de diseño)
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        // Obtenga el elemento de su conjunto de datos en esta posición y reemplace el contenido de la vista con ese elemento

        val song: Song = this.dataSet[position]

        val context = binding.itemView.context

        val idRes = context.resources.getIdentifier(song.picture, "drawable", context.packageName)

        binding.name.text = song.name
        binding.info.text = song.info
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener {
            Toast.makeText(context, "Click Picture $position", Toast.LENGTH_SHORT).show()
        }
        // o position == 0
        if (song.id == 400) {
            binding.additionalText.visibility = View.VISIBLE
        }

        if(song.info == "Rock"){
            binding.imgRock.visibility = View.VISIBLE
        }

        binding.checkFavorite.setOnClickListener {
            if(binding.checkFavorite.isChecked){
                Toast.makeText(context, "Agregado a favoritos", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Eliminado de favoritos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPlay.setOnClickListener {
            Toast.makeText(context, "Se dio click en el Boton Play", Toast.LENGTH_SHORT).show()
        }
        binding.btnPause.setOnClickListener {
            Toast.makeText(context, "Se dio click en el Boton Pause", Toast.LENGTH_SHORT).show()
        }

        binding.btnShare.setOnClickListener {

            val shareName = "Oye escucha esta canción, se llama ${song.name}"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.putExtra(Intent.EXTRA_TEXT, shareName)
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException){
                Toast.makeText(context, "La app Whatsapp no se encuentra instalada", Toast.LENGTH_SHORT).show()
            }

        }
    }

    //Devuelve el tamaño de tu conjunto de datos (invocado por el administrador de diseño)
    override fun getItemCount(): Int = dataSet.size
}
