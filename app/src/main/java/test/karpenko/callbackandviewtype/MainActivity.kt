package test.karpenko.callbackandviewtype

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import test.karpenko.callbackandviewtype.databinding.ActivityMainBinding
import test.karpenko.callbackandviewtype.models.Animal
import test.karpenko.callbackandviewtype.models.Cat
import test.karpenko.callbackandviewtype.models.Dog
import test.karpenko.callbackandviewtype.models.Sparrow
import java.util.jar.Attributes

class MainActivity : AppCompatActivity(), OnAnimalClick {

    private lateinit var binding: ActivityMainBinding
    private lateinit var animalAdapter: AnimalsAdapter
    private val listOfAnimals = mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animalAdapter = AnimalsAdapter()
        setUpRecyclerView()
    /*    animalAdapter.setCallback(object : OnAnimalClick {
            override fun onAnimalClickExclamationListener(animal: Animal) {
                Toast.makeText(this@MainActivity, animal.voice(), Toast.LENGTH_SHORT).show()
            }
        })*/
        animalAdapter.animalsList = listOfAnimals as ArrayList<Animal>
        animalAdapter.setCallback(this)

    }

    private fun setUpRecyclerView() {
        for (i in 0 until 5) {
            listOfAnimals.add(Dog("Dog $i", false))
            listOfAnimals.add(Cat("Cat $i", false))
            listOfAnimals.add(Sparrow("Sparrow $i", true))
        }
        val rvList = binding.animalsRV
        rvList.apply {
            adapter = animalAdapter
            layoutManager = LinearLayoutManager(context)
            recycledViewPool.setMaxRecycledViews(
                AnimalsAdapter.VIEW_TYPE_ENABLED,
                AnimalsAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                AnimalsAdapter.VIEW_TYPE_DISABLE,
                AnimalsAdapter.MAX_POOL_SIZE
            )
        }
    }

    override fun onAnimalClickExclamationListener(animal: Animal) {
        Toast.makeText(this, animal.voice(), Toast.LENGTH_SHORT).show()
    }


}