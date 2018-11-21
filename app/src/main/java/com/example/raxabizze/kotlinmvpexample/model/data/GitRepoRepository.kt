package com.example.raxabizze.kotlinmvpexample.model.data

import com.example.raxabizze.kotlinmvpexample.model.Repository
import com.example.raxabizze.kotlinmvpexample.utils.NetManager
import io.reactivex.Observable
import javax.inject.Inject

class GitRepoRepository @Inject constructor(var netManager: NetManager) {

    private val localDataSource = GitRepoLocalDataSource()
    private val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(): Observable<ArrayList<Repository>> {

        netManager.isConnectedToInternet?.let {
            if (it) {
                //todo save those data to local data store
                return remoteDataSource.getRepositories()
            }
        }
        return localDataSource.getRepositories()
    }
}




