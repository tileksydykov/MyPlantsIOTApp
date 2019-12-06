package kg.flaterlab.myplants.Adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kg.flaterlab.myplants.R
import kotlinx.android.synthetic.main.my_adapter_item.view.*

class MyAdapter(private val myDataset: Array<String>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_adapter_item, parent, false) as LinearLayout

        return MyViewHolder(linearLayout)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.linearLayout.textView.text = myDataset[position]
        holder.linearLayout.setOnClickListener{

        }
    }
    override fun getItemCount() = myDataset.size
}