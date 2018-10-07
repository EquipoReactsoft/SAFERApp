package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.User;
import com.reactsoft.safer.domain.repository.UserRepository;

public class UpdateUser extends UseCase<User, Boolean> {
  private final UserRepository userRepository;

  public UpdateUser(UseCaseExecutor useCaseExecutor, UserRepository userRepository) {
    super(useCaseExecutor);
    this.userRepository = userRepository;
  }

  @Override
  public ObservableTask<Boolean> createObservableTask(User user) {
    return userRepository.putUser(user);
  }
}
