package com.example.bikerentalapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bikerentalapplication.R
import com.example.bikerentalapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    val categoryNameArray = arrayOf(
        "Bajaj Bike",
        "Ducati",
        "Harley-Davidson",
        "Honda Bike",
        "Royal Enfield",
        "Suzuki",
        "TVS Bike",
        "Indian Bike",
        "Bianchi",
        "KTM",
        "Kawasaki",
        "Hero Bike",
        "Yamaha Bike")

    val categoryImageArray = arrayOf(
        R.drawable.bajaj,
        R.drawable.ducati,
        R.drawable.harly,
        R.drawable.honda,
        R.drawable.royal,
        R.drawable.suzuki,
        R.drawable.tvs,
        R.drawable.indian,
        R.drawable.birachi,
        R.drawable.ktm,
        R.drawable.kawasaki,
        R.drawable.hero,
        R.drawable.yamaha
    )
    private lateinit var arraylist: ArrayList<Customdetail>
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //var context : FragmentActivity? = activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        _binding?.recyclerView?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        var animator: RecyclerView.ItemAnimator = DefaultItemAnimator()
        _binding?.recyclerView?.itemAnimator = animator
        arraylist = ArrayList()
        for (i in 0..categoryNameArray.size - 1) {
            var list: Customdetail = Customdetail(categoryNameArray.get(i), categoryImageArray.get(i))
            arraylist.add(list)
        }
        Log.d("RESPONSE", arraylist.size.toString())
  var recyclerAdpter : CustomRecyclerAdpter1 = CustomRecyclerAdpter1(requireContext(),arraylist)
        _binding?.recyclerView?.adapter = recyclerAdpter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}