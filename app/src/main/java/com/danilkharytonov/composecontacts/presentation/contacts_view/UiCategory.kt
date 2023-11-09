package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.domain.model.Category

enum class UiCategory {
    ALL, FAMILY, FRIENDS, WORK
}

fun Category.toUi(): UiCategory {
    return when (this) {
        Category.ALL -> UiCategory.ALL
        Category.FAMILY -> UiCategory.FAMILY
        Category.FRIENDS -> UiCategory.FRIENDS
        Category.WORK -> UiCategory.WORK
    }
}

fun UiCategory.toDomain(): Category {
    return when (this) {
        UiCategory.ALL -> Category.ALL
        UiCategory.FAMILY -> Category.FAMILY
        UiCategory.FRIENDS -> Category.FRIENDS
        UiCategory.WORK -> Category.WORK
    }
}