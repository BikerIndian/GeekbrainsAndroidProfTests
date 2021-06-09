package net.svishch.github.presenter.details

import net.svishch.github.presenter.PresenterContract

internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
