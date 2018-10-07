package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Photo;
import com.reactsoft.safer.domain.repository.PhotoRepository;

public class GetPhoto extends UseCase<String, Photo> {
  private final PhotoRepository photoRepository;

  public GetPhoto(UseCaseExecutor useCaseExecutor, PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.photoRepository = photoRepository;
  }

  @Override
  public ObservableTask<Photo> createObservableTask(final String photoId) {
    return photoRepository.getPhoto(photoId);
  }
}
