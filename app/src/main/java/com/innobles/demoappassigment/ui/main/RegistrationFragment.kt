package com.innobles.demoappassigment.ui.main

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.innobles.demoappassigment.databinding.MainFragmentBinding
class RegistrationFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationFragment()
    }

     private val viewM: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater,container,false).apply {
            lifecycleOwner = this@RegistrationFragment
            vm = viewM
            frament = this@RegistrationFragment
        }
        init()
        return binding.root
    }

    private fun init(){
     viewM.confirmPassword.observe(this.viewLifecycleOwner, Observer {
         binding.tvPasswordConfirm.validate("Invalid Confirm password"){ s -> s.equals(viewM.password.value) }
     })
     viewM.email.observe(this.viewLifecycleOwner, Observer {
            binding.tvEmail.validate("Invalid email"){ s -> Patterns.EMAIL_ADDRESS.matcher(s).matches() }
   })


    }

    private fun validator(): Boolean {
        return binding.tvEmail.isValid()?: false && binding.tvPassword.isValid() ?: false && binding.tvPasswordConfirm.isValid() ?: false
    }

    fun onSubmit(){
        if (!validator()){
            binding?.let {
                binding.tvEmail.validate("Please Enter email"){ s -> Patterns.EMAIL_ADDRESS.matcher(s).matches() }
                binding.tvPassword.validate("Please Enter password"){ s -> s.isNotEmpty() }
                binding.tvPasswordConfirm.validate("Please Enter confirm password"){ s -> s.equals(viewM.password.value) }

            }
        }
    }

}