package net.svishch.github.repository


import net.svishch.github.model.SearchResponse
import net.svishch.github.presenter.RepositoryContract
import net.svishch.github.repository.RepositoryCallback
import retrofit2.Response

internal class  GitHubRepository(private val gitHubApi: GitHubApi) : RepositoryContract {

    override fun searchGithub(
        query: String,
        callback: RepositoryCallback
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }
}
