package com.danilkharytonov.data.repository.mappers

import com.danilkharytonov.core.base.Mapper
import com.danilkharytonov.data.database.model.SubUserEntity
import com.danilkharytonov.domain.model.ContactUser

class MapperDomainContactUserToEntity : Mapper<ContactUser, SubUserEntity> {
    override fun map(entity: ContactUser): SubUserEntity {
        return SubUserEntity(
            uuid = entity.uuid,
            name = entity.name,
            surname = entity.surname,
            phoneNumber = entity.phoneNumber,
            email = entity.email,
            dateOfBirth = entity.dateOfBirth,
            iconImage = entity.iconImage,
            category = entity.category
        )
    }
}