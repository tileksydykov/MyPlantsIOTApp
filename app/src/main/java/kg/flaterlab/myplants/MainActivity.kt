package kg.flaterlab.myplants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kg.flaterlab.myplants.Adapter.MyAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewManager :LinearLayoutManager
    private lateinit var viewAdapter :MyAdapter
    private lateinit var recyclerView :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(arrayOf("hello", "hell"))

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}