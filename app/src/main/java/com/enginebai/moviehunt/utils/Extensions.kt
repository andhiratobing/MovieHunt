package com.enginebai.moviehunt.utils

import android.app.Activity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.enginebai.moviehunt.R

fun Activity.openFragment(
    fragment: Fragment,
    addToBackStack: Boolean
) {
    this as AppCompatActivity
    supportFragmentManager.beginTransaction().apply {
        add(R.id.fragmentContainer, fragment)
        if (addToBackStack) addToBackStack(fragment.toString())
        commitAllowingStateLoss()
    }
}

fun ImageView.loadImage(url: String?, circular: Boolean = false) {
    load(url) {
        error(R.color.grey)
        placeholder(R.color.colorPrimary)
        crossfade(true)
        if (circular) transformations(CircleCropTransformation())
    }
}