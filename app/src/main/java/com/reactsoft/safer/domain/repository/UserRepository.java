package com.reactsoft.safer.domain.repository;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.User;


public interface UserRepository {
  ObservableTask<User> getUser(String userId);

  ObservableTask<Boolean> putUser(User user);
}
