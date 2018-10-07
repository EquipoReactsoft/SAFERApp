package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.repository.AuthenticatedUserRepository;


public class GetAuthenticatedUserUid extends UseCase<Void, String> {
  private final AuthenticatedUserRepository authenticatedUserRepository;

  public GetAuthenticatedUserUid(UseCaseExecutor useCaseExecutor,
      AuthenticatedUserRepository authenticatedUserRepository) {
    super(useCaseExecutor);
    this.authenticatedUserRepository = authenticatedUserRepository;
  }

  @Override
  public ObservableTask<String> createObservableTask(Void input) {
    return authenticatedUserRepository.getUserUid();
  }
}