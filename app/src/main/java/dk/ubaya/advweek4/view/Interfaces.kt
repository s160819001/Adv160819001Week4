package dk.ubaya.advweek4.view

import android.view.View
import dk.ubaya.advweek4.model.Student

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}

interface ButtonNotifClickListener{
    fun onButtonNotifClick(v:View, obj:Student)
}