package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.User;

import com.spring.cocomarket.exception.UsernameAlreadyUsedException;
import com.spring.cocomarket.interfaces.UserService;
import com.spring.cocomarket.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	/*@Override
	public User connect(User user) throws UsernameAlreadyUsedException {
		User dbUser = userRepo.findByFirstname(user.getFirstname());

		if (dbUser != null) {

			if (dbUser.getConnected()) {
				throw new UsernameAlreadyUsedException("This user is already connected: " + dbUser.getFirstname());
			}

			dbUser.setConnected(true);
			return userRepo.save(dbUser);
		}

		user.setConnected(true);
		return userRepo.save(user);
	}

	@Override
	public User disconnect(User user) {
		if (user == null) {
			return null;
		}

		User dbUser = userRepo.findByFirstname(user.getFirstname());
		if (dbUser == null) {
			return user;
		}

		dbUser.setConnected(false);
		return userRepo.save(dbUser);
	}
*/

}
