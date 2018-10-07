package com.reactsoft.safer.domain.repository;

import com.reactsoft.safer.domain.common.ObservableTask;

public interface AuthenticatedUserRepository {
  ObservableTask<String> getUserUid();
}
