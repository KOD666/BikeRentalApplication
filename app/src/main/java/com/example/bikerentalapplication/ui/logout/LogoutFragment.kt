package com.example.bikerentalapplication.ui.logout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bikerentalapplication.ConstantData
import com.example.bikerentalapplication.DrawerActivity
import com.example.bikerentalapplication.LoginActivity
import com.example.bikerentalapplication.databinding.FragmentLogoutBinding
import com.example.bikerentalapplication.databinding.FragmentProfileBinding
import com.example.bikerentalapplication.ui.profile.LogoutViewModel

class LogoutFragment : Fragment() {

    private var _binding: FragmentLogoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var sp : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(LogoutViewModel::class.java)

        _binding = FragmentLogoutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        sp = activity?.getSharedPreferences(ConstantData.PREF, Context.MODE_PRIVATE)!!

        sp.edit().clear().commit()
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}