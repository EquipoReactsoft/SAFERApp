package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Like;
import com.reactsoft.safer.domain.repository.LikeRepository;


public class LikePhoto extends UseCase<Like, Boolean> {
  private final LikeRepository likeRepository;

  public LikePhoto(UseCaseExecutor useCaseExecutor, LikeRepository likeRepository) {
    super(useCaseExecutor);
    this.likeRepository = likeRepository;
  }

  @Override
  public ObservableTask<Boolean> createObservableTask(final Like like) {
    return likeRepository.toggleLike(like);
  }
}