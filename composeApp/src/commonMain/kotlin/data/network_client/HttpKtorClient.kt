package data.network_client

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpKtorClient(private val httpClientEngine: HttpClientEngine) {

    fun build(): HttpClient {
        return HttpClient(httpClientEngine) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.d {
                            message
                        }
                    }
                }
                this.level = LogLevel.ALL
           /*     if (BuildConfig.DEBUG) {
                    this.level = LogLevel.ALL
                } else {
                    this.level = LogLevel.NONE
                }*/
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
             //   accept(ContentType.Application.Json)
            }
        }
    }
}