package com.javr.earthquake_monitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.javr.earthquake_monitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerEq.layoutManager = LinearLayoutManager(this)

        val lstEarthquake: MutableList<Earthquake> = mutableListOf()

        lstEarthquake.add(Earthquake("1", "Guayaquil", 4.3, 272727272, -102.312312, 33.232323232))
        lstEarthquake.add(Earthquake("2", "Quito", 1.3, 2323232323, -103.312312, 34.232323232))
        lstEarthquake.add(Earthquake("3", "Cuenca", 2.5, 34344334, -104.312312, 35.232323232))
        lstEarthquake.add(Earthquake("4", "Ibarra", 6.4, 5656565656, -105.312312, 36.232323232))
        lstEarthquake.add(Earthquake("5", "Chongon", 8.0, 787878878, -106.312312, 37.232323232))
        lstEarthquake.add(Earthquake("6", "Ambato", 2.0, 909090, -107.312312, 38.232323232))

        val adapter = EqAdapter()
        binding.recyclerEq.adapter = adapter
        adapter.submitList(lstEarthquake)

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

        if (lstEarthquake.isEmpty()){
            binding.eqEmptyView.visibility = View.VISIBLE
        }else{
            binding.eqEmptyView.visibility = View.GONE
        }
    }
}