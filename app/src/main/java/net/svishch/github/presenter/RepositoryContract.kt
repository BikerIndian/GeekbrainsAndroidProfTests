package net.svishch.github.presenter

import net.svishch.github.repository.RepositoryCallback


internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )
}
