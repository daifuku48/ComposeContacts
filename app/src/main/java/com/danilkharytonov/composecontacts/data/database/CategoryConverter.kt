package com.danilkharytonov.composecontacts.data.database

import androidx.room.TypeConverter
import com.danilkharytonov.composecontacts.domain.model.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category?): String? {
        return category?.name
    }

    @TypeConverter
    fun toCategory(categoryStr: String?): Category? {
        return categoryStr?.let { Category.valueOf(it) }
    }
}