package com.reactsoft.safer.data.repository.loggedUser;

import com.reactsoft.safer.domain.common.ObservableTask;

public interface LoggedUserDataSource {
  ObservableTask<String> get();
}
