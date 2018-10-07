package com.reactsoft.safer.ui.orchestrator;

import com.reactsoft.safer.domain.common.ObservableTask;
import com.reactsoft.safer.domain.common.Subscriber;
import com.reactsoft.safer.domain.common.UseCase;
import com.reactsoft.safer.domain.executor.UseCaseExecutor;
import com.reactsoft.safer.domain.interactors.GetUser;
import com.reactsoft.safer.domain.model.Comment;
import com.reactsoft.safer.domain.model.User;
import com.reactsoft.safer.ui.model.CommentItem;


public class GetCommentItem extends UseCase<Comment, CommentItem> {
  private final GetUser getUser;

  public GetCommentItem(UseCaseExecutor useCaseExecutor, GetUser getUser) {
    super(useCaseExecutor);
    this.getUser = getUser;
  }

  @Override
  public ObservableTask<CommentItem> createObservableTask(final Comment comment) {
    return new ObservableTask<CommentItem>() {
      @Override
      public void run(final Subscriber<CommentItem> result) {
        getUser.createObservableTask(comment.getUserId()).run(new Subscriber<User>() {
          @Override
          public void onSuccess(User user) {
            result.onSuccess(
                CommentItem.Builder()
                    .commentId(comment.getId())
                    .content(comment.getContent())
                    .userNickname(user.getUsername())
                    .userAvatarUrl(user.getPhotoUrl())
                    .build());
          }

          @Override
          public void onError(Exception exception) {
            result.onError(exception);
          }
        });
      }
    };
  }
}
