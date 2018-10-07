package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.User;
import com.reactsoft.safer.domain.repository.UserRepository;

public class GetUser extends UseCase<String, User> {
  private final UserRepository userRepository;

  public GetUser(UseCaseExecutor useCaseExecutor, UserRepository userRepository) {
    super(useCaseExecutor);
    this.userRepository = userRepository;
  }

  @Override
  public ObservableTask<User> createObservableTask(final String userId) {
    return userRepository.getUser(userId);
  }
}
