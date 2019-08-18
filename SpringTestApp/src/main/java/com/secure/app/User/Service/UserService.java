package com.secure.app.User.Service;

import com.secure.app.model.User;

public interface UserService {
	void save(User user);
    User findByUsername(String username);

}
