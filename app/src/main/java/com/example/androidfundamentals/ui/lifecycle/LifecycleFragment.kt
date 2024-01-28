package com.example.androidfundamentals.ui.lifecycle

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidfundamentals.R
import com.example.androidfundamentals.App
import com.example.androidfundamentals.AppNotificationDelegate

class LifecycleFragment : Fragment() {

    companion object {
        const val TAG = "LifecycleFragment"
        fun newInstance() = LifecycleFragment()
    }

    private lateinit var viewModel: LifecycleViewModel
    private lateinit var app : App
    private var mLastNotificationId : Int? = null
    private val appNotificationDelegate : AppNotificationDelegate by lazy {
        AppNotificationDelegate(this.requireContext())
    }

    override fun onDestroy() {
        showLocalNotification("onDestroy")
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LifecycleViewModel::class.java)
        showLocalNotification("onCreate")
    }

    override fun onAttach(context: Context) {
        showLocalNotification("onDestroy")
        super.onAttach(context)
        app = context?.applicationContext as App
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showLocalNotification("onCreateView")
        return inflater.inflate(R.layout.fragment_lifecycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLocalNotification("onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        showLocalNotification("onViewStateRestored with $savedInstanceState")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onPause() {
        showLocalNotification("onPause")
        super.onPause()
    }

    override fun onStop() {
        showLocalNotification("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        showLocalNotification("onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        showLocalNotification("onDetach")
        super.onDetach()
    }

    private fun showLocalNotification(text: String) {
        appNotificationDelegate.requestPermissions()
        mLastNotificationId = appNotificationDelegate.showLifecycleNotification(text, TAG)
    }

}