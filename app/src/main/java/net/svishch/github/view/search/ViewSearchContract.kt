package net.svishch.github.view.search

import net.svishch.github.model.SearchResult
import net.svishch.github.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
