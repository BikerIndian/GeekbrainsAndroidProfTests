package net.svishch.github.view.details

import net.svishch.github.view.ViewContract

internal interface ViewDetailsContract : ViewContract {
    fun setCount(count: Int)
}
