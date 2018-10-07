package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.Subscriber;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Photo;
import com.reactsoft.safer.domain.model.UnpublishedPhoto;
import com.reactsoft.safer.domain.repository.PhotoRepository;

public class PublishPhoto extends UseCase<UnpublishedPhoto, Photo> {
  private final UploadPhoto uploadPhoto;
  private final PhotoRepository photoRepository;

  public PublishPhoto(UseCaseExecutor useCaseExecutor, UploadPhoto uploadPhoto,
                      PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.uploadPhoto = uploadPhoto;
    this.photoRepository = photoRepository;
  }

  @Override
  public ObservableTask<Photo> createObservableTask(final UnpublishedPhoto unpublishedPhoto) {
    return new ObservableTask<Photo>() {
      @Override
      public void run(Subscriber<Photo> result) {
        String photoUri = uploadPhoto.createObservableTask(unpublishedPhoto.getPhotoUri()).getResult();
        photoRepository.publishPhoto(unpublishedPhoto.withPhotoUri(photoUri)).run(result);
      }
    };
  }
}
