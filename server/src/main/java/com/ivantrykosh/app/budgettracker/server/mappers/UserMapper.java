package com.ivantrykosh.app.budgettracker.server.mappers;

import com.ivantrykosh.app.budgettracker.server.dtos.UserDto;
import com.ivantrykosh.app.budgettracker.server.model.User;

/**
 * Mapper for User
 */
public class UserMapper implements Mapper<User, UserDto> {

    /**
     * Convert from User to UserDto
     * @param user user to convert
     * @return UserDto of user
     */
    @Override
    public UserDto convertToDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setPasswordSalt(user.getPasswordSalt());
        userDto.setPasswordHash(user.getPasswordHash());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setIsVerified(user.getIsVerified());
        return userDto;
    }

    /**
     * Convert from UserDto to User
     * @param userDto userDto to convert
     * @return User of userDto
     */
    @Override
    public User convertToEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setEmail(userDto.getEmail());
        user.setPasswordSalt(userDto.getPasswordSalt());
        user.setPasswordHash(userDto.getPasswordHash());
        user.setRegistrationDate(userDto.getRegistrationDate());
        user.setIsVerified(userDto.getIsVerified());
        return user;
    }
}