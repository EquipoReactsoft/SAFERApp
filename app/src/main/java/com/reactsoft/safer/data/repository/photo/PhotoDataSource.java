package com.reactsoft.safer.data.repository.photo;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.Photo;
import com.reactsoft.safer.domain.model.UnpublishedPhoto;

import java.util.List;

public interface PhotoDataSource {
  ObservableTask<Photo> getPhoto(String photoId);

  ObservableTask<List<Photo>> getPhotos();

  ObservableTask<Photo> publishPhoto(UnpublishedPhoto unpublishedPhoto);

  ObservableTask<String> uploadPhoto(String photoUri);
}
