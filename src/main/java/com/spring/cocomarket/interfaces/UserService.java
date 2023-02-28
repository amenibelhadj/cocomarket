package com.spring.cocomarket.interfaces;

import com.spring.cocomarket.entities.User;
import com.spring.cocomarket.exception.UsernameAlreadyUsedException;


public interface UserService {
    /**
     * <p>
     * Find the user by its user name. If the user is not saved yet,
     * then save the user into database, otherwise throw a {@link UsernameAlreadyUsedException}
     * </p>
     *
     * @param user
     * @return The connected user
     * @throws UsernameAlreadyUsedException
     *//*
    User connect(User user) throws UsernameAlreadyUsedException;

    *//**
     * <p>
     * Remove the user from the database.
     * </p>
     *
     * @param user
     *//*
     User disconnect(User user);

*/
}
