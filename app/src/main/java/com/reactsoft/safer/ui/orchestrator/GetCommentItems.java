package com.reactsoft.safer.ui.orchestrator;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.Subscriber;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.interactors.GetPhotoComments;
import com.reactsoft.safer.domain.model.Comment;
import com.reactsoft.safer.ui.model.CommentItem;

import java.util.LinkedList;
import java.util.List;

public class GetCommentItems extends UseCase<String, List<CommentItem>> {
  private final GetPhotoComments getPhotoComments;
  private final GetCommentItem getCommentItem;

  public GetCommentItems(UseCaseExecutor useCaseExecutor, GetPhotoComments getPhotoComments,
                         GetCommentItem getCommentItem) {
    super(useCaseExecutor);
    this.getPhotoComments = getPhotoComments;
    this.getCommentItem = getCommentItem;
  }

  @Override
  public ObservableTask<List<CommentItem>> createObservableTask(final String photoId) {
    return  new ObservableTask<List<CommentItem>>() {
      @Override
      public void run(Subscriber<List<CommentItem>> result) {
        List<CommentItem> commentItems = new LinkedList<>();
        List<Comment> comments = getPhotoComments.createObservableTask(photoId).getResult();
        if (comments != null) {
          for (Comment comment : comments) {
            commentItems.add(getCommentItem.createObservableTask(comment).getResult());
          }
        }
        result.onSuccess(commentItems);
      }
    };
  }
}
