package net.svishch.github

import net.svishch.github.presenter.details.DetailsPresenter
import net.svishch.github.view.details.DetailsActivity
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: DetailsActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter(viewContract)
    }

    @Test
    fun onIncrement() {
        val setNum = 0
        val result = 1

        presenter.setCounter(setNum)
        presenter.onIncrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(result)
    }

    @Test
    fun onDecrement() {
        val setNum = 1
        val result = 0

        presenter.setCounter(setNum)
        presenter.onDecrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(result)
    }


    @Test
    fun onIncrementAndOnDecrement() {
        val setNum = 0
        val result = 0

        presenter.setCounter(setNum)
        presenter.onIncrement()
        presenter.onDecrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(result)
    }

}