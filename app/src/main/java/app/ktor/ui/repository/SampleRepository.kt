package app.ktor.ui.repository

import app.ktor.ui.model.Sample
import app.ktor.ui.network.KtorClient
import io.ktor.client.request.*

object SampleRepository {


    suspend fun getSimpleDetail(): Sample {
        return KtorClient.httpClient.use {
            it.get("https://reqres.in/api/products/")
        }
    }


}