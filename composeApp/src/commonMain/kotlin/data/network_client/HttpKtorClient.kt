package data.network_client

import data.authentication.local.AuthorizationLocalDataSource
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import isDebug
import kotlinx.serialization.json.Json

class HttpKtorClient(
    private val httpClientEngine: HttpClientEngine,
    private val authorizationLocalDataSource: AuthorizationLocalDataSource) {

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

                if (isDebug()) {
                    this.level = LogLevel.ALL
                } else {
                    this.level = LogLevel.NONE
                }
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            /** REMOVED AS TESTING WITH PASSWORD SIGN-IN */
/*
            install(Auth) {
                this.bearer {
                    this.loadTokens {
                        authorizationLocalDataSource.get()?.let { tokens ->
                            BearerTokens(
                                accessToken = tokens.tokenId,
                                refreshToken = tokens.refreshToken
                            )
                        }
                    }

                    this.refreshTokens {
                        val tokenAuthorizationModel = authorizationLocalDataSource.get()

                        tokenAuthorizationModel?.let { tokens ->
                            val requestBody = buildJsonObject {
                                this.put("grant_type", "refresh_token")
                                this.put("refresh_token", tokenAuthorizationModel.refreshToken)
                            }

                            */
/** Make request to update the tokenId using the refresh token to get a new tokenId and refresh token *//*

                            val tokenRefreshResponseDto = client.post(Routes.TOKEN) {
                                this.setBody(requestBody)
                                this.url {
                                    this.parameters.append("key", BuildConfig.FIREBASE_AUTHENTICATION_API_KEY)
                                }
                            }.body<TokenRefreshResponseDto>()

                            */
/** Save updated token to the cache *//*

                            if (tokenRefreshResponseDto != null) {
                                val tokenAuthorizationModel = TokenAuthorizationModel(
                                    tokenId = tokenRefreshResponseDto.idToken,
                                    refreshToken = tokenRefreshResponseDto.refreshToken
                                )

                                authorizationLocalDataSource.set(tokenAuthorizationModel)

                                */
/** Updated tokens *//*

                                BearerTokens(
                                    accessToken = tokenRefreshResponseDto.idToken,
                                    refreshToken = tokenRefreshResponseDto.refreshToken
                                )
                            } else {
                                */
/** Just return empty as request failed to get tokens *//*

                                BearerTokens(
                                    accessToken = "",
                                    refreshToken = ""
                                )
                            }
                        }
                    }
                }
            }
*/
        }
    }
}