package com.reactsoft.safer.data.repository.comment;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.Comment;
import com.reactsoft.safer.domain.model.UnpublishedComment;
import com.reactsoft.safer.domain.repository.CommentRepository;
import java.util.List;

public class CommentDataRepository implements CommentRepository {
  private final CommentDataSource commentDataSource;

  public CommentDataRepository(CommentDataSource commentDataSource) {
    this.commentDataSource = commentDataSource;
  }

  @Override
  public ObservableTask<List<Comment>> getComments(String photoId) {
    return commentDataSource.getComments(photoId);
  }

  @Override
  public ObservableTask<Comment> publishComment(UnpublishedComment unpublishedComment) {
    return commentDataSource.publishComment(unpublishedComment);
  }
}
