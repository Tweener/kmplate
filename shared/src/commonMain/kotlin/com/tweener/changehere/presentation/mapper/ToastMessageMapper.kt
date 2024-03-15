package com.tweener.changehere.presentation.mapper

import com.tweener.changehere.presentation.model.ToastMessage
import com.tweener.changehere.presentation.screen.detail.mapper.DetailToastMessage
import kmplate.shared.generated.resources.Res
import kmplate.shared.generated.resources.detail_load_data
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.getString

/**
 * @author Vivien Mahe
 * @since 29/12/2023
 */
class ToastMessageMapper {

    @OptIn(ExperimentalResourceApi::class)
    suspend fun convertToUiModel(entity: ToastMessage): String =
        when (entity) {
            is DetailToastMessage.LoadData -> getString(resource = Res.string.detail_load_data, entity.id)
            else -> ""
        }
}
