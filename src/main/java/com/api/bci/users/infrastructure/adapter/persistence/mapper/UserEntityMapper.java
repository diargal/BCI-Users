package com.api.bci.users.infrastructure.adapter.persistence.mapper;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.infrastructure.adapter.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserEntityMapper {
    UserEntity toEntity(UserRequest userRequest);

    UserResponse toModel(UserEntity userEntity);

    void updateUserFromModel(UserRequest userRequest, @MappingTarget UserEntity userEntity);
}
