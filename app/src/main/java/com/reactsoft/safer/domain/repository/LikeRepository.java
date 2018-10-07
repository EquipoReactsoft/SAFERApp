package com.reactsoft.safer.domain.repository;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.Like;


import java.util.List;

public interface LikeRepository {
  ObservableTask<List<Like>> getLikes(String photoId);

  ObservableTask<Boolean> toggleLike(Like like);
}
