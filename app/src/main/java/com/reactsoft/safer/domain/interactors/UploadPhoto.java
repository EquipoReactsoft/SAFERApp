package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.repository.PhotoRepository;

public class UploadPhoto extends UseCase<String, String> {
  private final PhotoRepository photoRepository;

  public UploadPhoto(UseCaseExecutor useCaseExecutor, PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.photoRepository = photoRepository;
  }

  @Override
  public ObservableTask<String> createObservableTask(String localPhotoUri) {
    return photoRepository.uploadPhoto(localPhotoUri);
  }
}
