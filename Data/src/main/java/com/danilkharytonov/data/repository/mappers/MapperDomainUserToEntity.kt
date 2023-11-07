package com.danilkharytonov.data.repository.mappers

import com.danilkharytonov.core.base.Mapper
import com.danilkharytonov.data.database.model.MAIN_USER_ID
import com.danilkharytonov.data.database.model.MainUserEntity
import com.danilkharytonov.domain.model.User

class MapperDomainUserToEntity : Mapper<User, MainUserEntity> {
    override fun map(entity: User): MainUserEntity {
        return MainUserEntity(
            uuid = MAIN_USER_ID,
            name = entity.name,
            surname = entity.surname,
            phoneNumber = entity.phoneNumber,
            email = entity.email,
            dateOfBirth = entity.dateOfBirth,
            iconImage = entity.iconImage
        )
    }
}