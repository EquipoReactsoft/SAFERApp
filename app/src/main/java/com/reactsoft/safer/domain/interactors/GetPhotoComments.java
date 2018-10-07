package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Comment;
import com.reactsoft.safer.domain.repository.CommentRepository;


import java.util.List;

public class GetPhotoComments extends UseCase<String, List<Comment>> {
  private final CommentRepository commentRepository;

  public GetPhotoComments(UseCaseExecutor useCaseExecutor, CommentRepository commentRepository)
  {
    super(useCaseExecutor);
    this.commentRepository = commentRepository;
  }

  @Override
  public ObservableTask<List<Comment>> createObservableTask(final String photoId)
  {
    return commentRepository.getComments(photoId);
  }
}
