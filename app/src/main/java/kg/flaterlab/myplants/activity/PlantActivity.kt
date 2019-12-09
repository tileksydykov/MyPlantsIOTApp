package kg.flaterlab.myplants.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kg.flaterlab.myplants.R
import kotlinx.android.synthetic.main.activity_plant.*


class PlantActivity : AppCompatActivity() {

    private val db = FirebaseDatabase.getInstance()
    val ref = db.getReference("plants")
    var hour = 1
    var minute = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant)

        val id = intent.getStringExtra("id")
        text.text = id

        ref.child("home").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                parse(dataSnapshot.value as String)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        ref.child("time").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val h  = (dataSnapshot.value as Long) - 1
                spinner.setSelection(h.toInt())
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })


        var selected = 1

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, itemSelected: View?, selectedItemPosition: Int, selectedId: Long) {
                selected = selectedItemPosition + 1
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinner_hour.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, itemSelected: View?, selectedItemPosition: Int, selectedId: Long) {
                hour = selectedItemPosition + 1
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinner_minutes.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, itemSelected: View?, selectedItemPosition: Int, selectedId: Long) {
                minute = selectedItemPosition
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        button2.setOnClickListener {
            ref.child("home").setValue("$hour:$minute")
            ref.child("time").setValue(selected)
        }

        button3.setOnClickListener {
            ref.child("home_now").setValue(1)
            ref.child("home_now").setValue(0)
        }
    }

    fun parse(time: String) {
        var h = time.split(":")[0].toInt()
        hour = h
        spinner_hour.setSelection(h - 1)
        h = time.split(":")[1].toInt()
        minute = h
        spinner_minutes.setSelection(h)
    }
}
