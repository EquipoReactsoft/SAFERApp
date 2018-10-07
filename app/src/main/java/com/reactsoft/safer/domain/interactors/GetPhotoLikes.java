package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Like;
import com.reactsoft.safer.domain.repository.LikeRepository;


import java.util.List;

public class GetPhotoLikes extends UseCase<String, List<Like>> {
  private final LikeRepository likeRepository;

  public GetPhotoLikes(UseCaseExecutor useCaseExecutor, LikeRepository likeRepository) {
    super(useCaseExecutor);
    this.likeRepository = likeRepository;
  }

  @Override
  public ObservableTask<List<Like>> createObservableTask(final String photoId) {
    return likeRepository.getLikes(photoId);
  }
}
