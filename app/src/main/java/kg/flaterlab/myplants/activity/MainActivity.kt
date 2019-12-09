package kg.flaterlab.myplants.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kg.flaterlab.myplants.R
import kg.flaterlab.myplants.adapter.MyAdapter
import kg.flaterlab.myplants.model.Plant

class MainActivity : AppCompatActivity() {
    private lateinit var viewManager :LinearLayoutManager
    private lateinit var viewAdapter :MyAdapter
    private lateinit var recyclerView :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(arrayOf(Plant(1, "FirstPlant", "10:00")), this)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}