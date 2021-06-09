package net.svishch.github.presenter.search

import net.svishch.github.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
    //onAttach
    //onDetach
}
