package presentation.utils

import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.error_disk_full
import busbytravelmatev2.composeapp.generated.resources.error_no_internet
import busbytravelmatev2.composeapp.generated.resources.error_payload_too_large
import busbytravelmatev2.composeapp.generated.resources.error_request_timeout
import busbytravelmatev2.composeapp.generated.resources.error_serialization
import busbytravelmatev2.composeapp.generated.resources.error_server_error
import busbytravelmatev2.composeapp.generated.resources.error_too_many_requests
import busbytravelmatev2.composeapp.generated.resources.error_unknown
import domain.utils.DataError

fun DataError.toUiText(): UiText {
    return when(this) {
        DataError.Local.DISK_FULL -> UiText.ResourceString(
            Res.string.error_disk_full
        )
        DataError.Network.REQUEST_TIMEOUT -> UiText.ResourceString(
            Res.string.error_request_timeout
        )
        DataError.Network.TOO_MANY_REQUESTS ->  UiText.ResourceString(
            Res.string.error_too_many_requests
        )
        DataError.Network.NO_INTERNET ->  UiText.ResourceString(
            Res.string.error_no_internet
        )
        DataError.Network.PAYLOAD_TOO_LARGE ->  UiText.ResourceString(
            Res.string.error_payload_too_large
        )
        DataError.Network.SERVER_ERROR ->  UiText.ResourceString(
            Res.string.error_server_error
        )
        DataError.Network.SERIALIZATION ->  UiText.ResourceString(
            Res.string.error_serialization
        )
        else -> UiText.ResourceString(
            Res.string.error_unknown
        )
    }
}