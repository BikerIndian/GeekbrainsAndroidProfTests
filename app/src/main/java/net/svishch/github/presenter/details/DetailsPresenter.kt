package net.svishch.github.presenter.details

import net.svishch.github.view.details.DetailsActivity


internal class DetailsPresenter internal constructor(
    private var viewContract: DetailsActivity?,
    private var count: Int = 0
) : PresenterDetailsContract {

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract?.setCount(count)
    }

    override fun onAttach() {

    }

    override fun onDetach() {
        viewContract = null
    }
}
