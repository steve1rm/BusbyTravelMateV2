package data.utils

object Routes {
    private const val BASE_URL = "https://identitytoolkit.googleapis.com/v1"
    const val SIGN_UP = "$BASE_URL/accounts:signUp"
    const val SIGN_IN_WITH_PASSWORD = "$BASE_URL/accounts:signInWithPassword"
    const val SIGN_IN_WITH_IDP = "$BASE_URL/accounts:signInWithIdp"
}