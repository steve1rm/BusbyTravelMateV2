package presentation.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

sealed interface UiText {
    /** Simple text non-string resources*/
    data class DynamicString(val value: String) : UiText
    /** Strings from string resources */
    class ResourceString(val resource: StringResource, val args: Array<Any> = emptyArray()) : UiText

    /** Used from composables */
    @Composable
    fun asString(): String {
        return when(this) {
            is DynamicString -> {
                this.value
            }
            is ResourceString -> {
                stringResource(resource = this.resource, this.args)

            }
        }
    }
}