package com.example.bikerentalapplication.ui.profile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bikerentalapplication.ConstantData
import com.example.bikerentalapplication.DBHelper
import com.example.bikerentalapplication.LoginActivity
import com.example.bikerentalapplication.R
import com.example.bikerentalapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var btnSignUp: Button
    private lateinit var signName: EditText
    private lateinit var SignPassword: EditText
    private lateinit var SignConfirmPassword: EditText
    private lateinit var singname1: EditText
    private lateinit var db: DBHelper
    private var emailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    lateinit var sp: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(LogoutViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sp = requireActivity().getSharedPreferences(ConstantData.PREF, Context.MODE_PRIVATE)

        singname1 = root.findViewById(R.id.profile_edtName1)
        btnSignUp = root.findViewById(R.id.profile_btnSignup)
        SignPassword = root.findViewById(R.id.profile_edtPassword)
        SignConfirmPassword = root.findViewById(R.id.profile_edtRePassword)
        signName = root.findViewById(R.id.profile_edtEmail)

        db = DBHelper(requireActivity())

        singname1.setText(sp.getString(ConstantData.NAME, ""))
        signName.setText(sp.getString(ConstantData.EMAIL, ""))
        SignPassword.setText(sp.getString(ConstantData.PASSWORD, ""))
        SignConfirmPassword.setText(sp.getString(ConstantData.PASSWORD, ""))

        btnSignUp.setOnClickListener {
            val signname2 = singname1.text.toString()
            val signText = signName.text.toString()
            val signPassword = SignPassword.text.toString()
            val signConfirmPassword = SignConfirmPassword.text.toString()
            db.updatedata(signname2, signText, signPassword)

            if (signname2.trim().isEmpty()) {
                singname1.error = "Enter Name"
            } else if (signText.trim().isEmpty()) {
                signName.error = "Enter Email Id missing @ - .com"
            } else if (signPassword.trim().isEmpty()) {
                SignPassword.error = "Enter Password"
            } else if (signConfirmPassword.trim().isEmpty()) {
                SignConfirmPassword.error = "Enter Confirm Password"
            } else if (signPassword.trim().length < 6) {
                SignPassword.error = "Enter You 6 no in Password"
            } else if (signConfirmPassword.trim().isEmpty()) {
                SignConfirmPassword.error = "Enter You 6 no in Password"
            }
            /*                if (TextUtils.isEmpty(signText) || TextUtils.isEmpty(signPassword) || TextUtils.isEmpty(
                                    signConfirmPassword
                                )
                            ) {
                                Toast.makeText(this, "Add User Password & ConformPassword", Toast.LENGTH_SHORT)
                                    .show()
                            }*/ else {
                if (signPassword.equals(signConfirmPassword)) {
                    /*if (saveData == true) {*/
                        Toast.makeText(
                            requireActivity(),
                            "Profile Update Successful",
                            Toast.LENGTH_SHORT
                        ).show()
                        sp.edit().putString(ConstantData.NAME, singname1.text.toString()).commit()
                        sp.edit().putString(ConstantData.EMAIL, signName.text.toString()).commit()
                        sp.edit().putString(ConstantData.PASSWORD, SignPassword.text.toString())
                            .commit()
                    /*} else {
                        Toast.makeText(requireActivity(), "User Not Exists", Toast.LENGTH_SHORT)
                            .show()
                    }*/
                } else {
                    Toast.makeText(requireActivity(), "Password Not Match", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}