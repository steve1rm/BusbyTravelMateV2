package data.authentication.local.imp

import kotlinx.serialization.json.Json

class AuthorizationLocalDataSourceImp(
  //  private val settings: Settings
) /*: AuthorizationLocalDataSource*/ {

    companion object {
        private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"

    }
/*
    override suspend fun get(): TokenAuthorizationModel? {
        *//*return withContext(Dispatchers.IO) {
          val json = sharedPreferences.getString(KEY_AUTH_INFO, null)

            json?.let {
                Json.decodeFromString<AuthorizationInfoSerializable>(json).toAuthorizationInfo()
            }
        }*//*

        TODO()
    }

    override suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
        if (tokenAuthorizationModel == null) {
            withContext(Dispatchers.Unconfined) {
               *//* sharedPreferences
                    .edit {
                        this.remove(KEY_AUTH_INFO)
                        this.apply()
                    }*//*
            }
        }
        else {
         *//*   val json = Json.encodeToString(authorizationInfo.toAuthorizationSerializable())

            sharedPreferences
                .edit {
                    this.putString(KEY_AUTH_INFO, json)
                    this.apply()
                }*//*
        }
    }*/
}

