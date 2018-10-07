package com.reactsoft.safer.data.repository.loggedUser;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.repository.AuthenticatedUserRepository;

public class AuthenticatedUserDataRepository implements AuthenticatedUserRepository {
  private final LoggedUserDataSource loggedUserDataSource;

  public AuthenticatedUserDataRepository(LoggedUserDataSource loggedUserDataSource) {
    this.loggedUserDataSource = loggedUserDataSource;
  }

  @Override
  public ObservableTask<String> getUserUid() {
    return loggedUserDataSource.get();
  }
}
