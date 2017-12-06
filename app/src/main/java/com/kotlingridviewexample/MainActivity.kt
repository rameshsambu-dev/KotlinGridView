package com.kotlingridviewexample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.javasampleapproach.kotlin.gridview.Food
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_entry.view.*

class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var foodsList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load foods
        foodsList.add(Food("Coffee", R.drawable.coffee_pot))
        foodsList.add(Food("Espersso", R.drawable.espresso))
        foodsList.add(Food("French Fires", R.drawable.french_fries))
        foodsList.add(Food("Honey",R.drawable.honey))
        foodsList.add(Food("Strawberry", R.drawable.strawberry_ice_cream))
        foodsList.add(Food("Sugar cubes", R.drawable.sugar_cubes))
        adapter = FoodAdapter(this, foodsList)

        gvFoods.adapter = adapter
    }

    class FoodAdapter : BaseAdapter {
        var foodsList = ArrayList<Food>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<Food>) : super() {
            this.context = context
            this.foodsList = foodsList
        }

        override fun getCount(): Int {
            return foodsList.size
        }

        override fun getItem(position: Int): Any {
            return foodsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.foodsList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_entry, null)
            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            return foodView
        }
    }
}
