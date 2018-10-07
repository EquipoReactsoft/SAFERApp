package com.reactsoft.safer.data.repository.user;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.User;

public interface UserDataSource {
  ObservableTask<User> get(String userId);

  ObservableTask<Boolean> put(User user);
}
