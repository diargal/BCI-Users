package com.api.bci.users.application.mapper;

import com.api.bci.users.application.dto.UserRequestDto;
import com.api.bci.users.application.dto.UserResponseDto;
import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
    UserResponseDto responseToDto(UserResponse userResponse);

    UserRequest requestToModel(UserRequestDto userRequestDto);
}
