package com.silverorange.videoplayer.ktx

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visible_flag")
fun View.visibleFlag(flag: Boolean) {
    if (flag) {
        this.show()
    } else {
        this.gone()
    }
}