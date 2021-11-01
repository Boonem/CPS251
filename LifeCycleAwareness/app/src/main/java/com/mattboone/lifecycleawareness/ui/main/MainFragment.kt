package com.mattboone.lifecycleawareness.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mattboone.lifecycleawareness.DemoObserver
import com.mattboone.lifecycleawareness.databinding.MainFragmentBinding
import com.mattboone.lifecycleawareness.R
import com.mattboone.lifecycleawareness.BR.myViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding : MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner ( this )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = SavedStateViewModelFactory(activity?.application, this)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)
        lifecycle.addObserver(DemoObserver()) //How do I get this to interact with my viewmodel instance?
    }
}