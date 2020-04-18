package com.example.demonhe

import android.view.View
import android.widget.TextView

class SetCountNotifications()
{
    private val MAXIMUM_COUNT = 100
    public fun increaseNotifications(view:View)
    {
        val count = view.findViewById<TextView>(R.id.tv_CountNotifications).text.toString()
        val numberNotification = count.toInt()
        if(numberNotification>=MAXIMUM_COUNT)
        {
            view.findViewById<TextView>(R.id.tv_CountNotifications).text = "99"
        }
        else view.findViewById<TextView>(R.id.tv_CountNotifications).text = (numberNotification+1).toString()
    }

}
