package com.reactsoft.safer.data.repository.like;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.Like;
import com.reactsoft.safer.domain.repository.LikeRepository;

import java.util.List;

public class LikeDataRepository implements LikeRepository {
  private final LikeDataSource likeDataSource;

  public LikeDataRepository(LikeDataSource likeDataSource) {
    this.likeDataSource = likeDataSource;
  }

  @Override
  public ObservableTask<List<Like>> getLikes(String photoId) {
    return likeDataSource.getLikes(photoId);
  }

  @Override
  public ObservableTask<Boolean> toggleLike(Like like) {
    return likeDataSource.toggleLike(like);
  }
}
