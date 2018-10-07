package com.reactsoft.safer.data.repository.comment;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.model.Comment;
import com.reactsoft.safer.domain.model.UnpublishedComment;

import java.util.List;

public interface CommentDataSource {
  ObservableTask<List<Comment>> getComments(String photoId);

  ObservableTask<Comment> publishComment(UnpublishedComment unpublishedComment);
}
