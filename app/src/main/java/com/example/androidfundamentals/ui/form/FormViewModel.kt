package com.example.androidfundamentals.ui.form

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    companion object {
        const val TAG = "FormViewModel"
    }
    // TODO: Implement the ViewModel
    var firstName: MutableLiveData<String> = MutableLiveData("hello firstname")
    var lastName: MutableLiveData<String> = MutableLiveData("hello lastName")
    var birthDate: MutableLiveData<String> = MutableLiveData("hello birthDate")
    var country: MutableLiveData<String> = MutableLiveData("hello country")

    fun onBtnApplyClick(context:Context) {
        Log.d(TAG, "onBtnApplyClick")
        Toast.makeText(context, "${firstName.value} ${lastName.value} ${birthDate.value} ${country.value}", Toast.LENGTH_LONG).show()

    }
}