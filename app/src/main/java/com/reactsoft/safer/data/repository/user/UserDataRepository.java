package com.reactsoft.safer.data.repository.user;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.User;
import com.reactsoft.safer.domain.repository.UserRepository;


public class UserDataRepository implements UserRepository {
  private final UserDataSource userDataSource;

  public UserDataRepository(UserDataSource userDataSource) {
    this.userDataSource = userDataSource;
  }


  @Override
  public ObservableTask<User> getUser(String userId) {
    return null;
  }

  @Override
  public ObservableTask<Boolean> putUser(User user) {
    return userDataSource.put(user);
  }
}
