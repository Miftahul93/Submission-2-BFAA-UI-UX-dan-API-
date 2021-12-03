package com.example.mysubmissiongithubuser.api

import com.example.mysubmissiongithubuser.model.DetailUserResponse
import com.example.mysubmissiongithubuser.model.User
import com.example.mysubmissiongithubuser.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    companion object {
        const val AUTH_TOKEN = "BuildConfig.AUTH_TOKEN"
    }

    @GET("search/users")
    @Headers("Autorization: token $AUTH_TOKEN")
    fun getSearchUsers(
            @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Autorization: token $AUTH_TOKEN")
    fun getUserDetail(
            @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Autorization: token $AUTH_TOKEN")
    fun getFollowers(
            @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Autorization: token $AUTH_TOKEN")
    fun getFollowing(
            @Path("username") username: String
    ): Call<ArrayList<User>>
}