package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Photo;
import com.reactsoft.safer.domain.repository.PhotoRepository;


import java.util.List;

public class GetPhotos extends UseCase<Void, List<Photo>> {
  private final PhotoRepository photoRepository;

  public GetPhotos(UseCaseExecutor useCaseExecutor, PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.photoRepository = photoRepository;
  }

  @Override
  public ObservableTask<List<Photo>> createObservableTask(Void input) {
    return photoRepository.getPhotos();
  }
}
