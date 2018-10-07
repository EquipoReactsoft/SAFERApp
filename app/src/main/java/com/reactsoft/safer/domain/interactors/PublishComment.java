package com.reactsoft.safer.domain.interactors;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.model.Comment;
import com.reactsoft.safer.domain.model.UnpublishedComment;
import com.reactsoft.safer.domain.repository.CommentRepository;

public class PublishComment extends UseCase<UnpublishedComment, Comment> {
  private final CommentRepository commentRepository;

  public PublishComment(UseCaseExecutor useCaseExecutor, CommentRepository commentRepository) {
    super(useCaseExecutor);
    this.commentRepository = commentRepository;
  }

  @Override
  public ObservableTask<Comment> createObservableTask(final UnpublishedComment unpublishedComment) {
    return commentRepository.publishComment(unpublishedComment);
  }
}
