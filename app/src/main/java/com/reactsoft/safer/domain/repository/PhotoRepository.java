package com.reactsoft.safer.domain.repository;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.Photo;
import com.reactsoft.safer.domain.model.UnpublishedPhoto;


import java.util.List;

public interface PhotoRepository {
  ObservableTask<Photo> getPhoto(String photoId);

  ObservableTask<List<Photo>> getPhotos();

  ObservableTask<Photo> publishPhoto(UnpublishedPhoto unpublishedPhoto);

  ObservableTask<String> uploadPhoto(String photoUri);
}
