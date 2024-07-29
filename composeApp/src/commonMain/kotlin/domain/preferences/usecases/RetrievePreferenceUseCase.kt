package domain.preferences.usecases

fun interface RetrievePreferenceUseCase {
    suspend fun execute(key: String): String?
}