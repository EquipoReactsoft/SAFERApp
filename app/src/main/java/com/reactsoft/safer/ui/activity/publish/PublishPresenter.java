package com.reactsoft.safer.ui.activity.publish;

import com.reactsoft.safer.domain.common.UseCaseCallback;
import com.reactsoft.safer.domain.interactors.GetAuthenticatedUserUid;
import com.reactsoft.safer.domain.interactors.PublishPhoto;
import com.reactsoft.safer.domain.model.Photo;
import com.reactsoft.safer.domain.model.UnpublishedPhoto;
import com.reactsoft.safer.ui.presenter.Presenter;


public class PublishPresenter extends Presenter<PublishPresenter.View> {
  private final GetAuthenticatedUserUid getAuthenticatedUserUid;
  private final PublishPhoto publishPhoto;

  private String currentUserUid;

  public PublishPresenter(GetAuthenticatedUserUid getAuthenticatedUserUid, PublishPhoto publishPhoto) {
    this.getAuthenticatedUserUid = getAuthenticatedUserUid;
    this.publishPhoto = publishPhoto;
  }

  @Override
  public void attach(View view) {
    super.attach(view);
    getAuthenticatedUserUid.execute(new GetCurrentUserUidCallback());
  }

  public void onRequestPublish(String photoUri, String photoDescription) {
    UnpublishedPhoto unpublishedPhoto = UnpublishedPhoto.Builder()
        .userId(currentUserUid)
        .photoUri(photoUri)
        .description(photoDescription)
        .build();
    publishPhoto.execute(unpublishedPhoto, new PublishPhotoCallback());
    view.showUploading();
  }

  private class GetCurrentUserUidCallback implements UseCaseCallback<String> {

    @Override
    public void onSuccess(String result) {
      currentUserUid = result;
    }

    @Override
    public void onError(Exception exception) {
    }
  }

  private class PublishPhotoCallback implements UseCaseCallback<Photo> {

    @Override
    public void onSuccess(Photo result) {
      view.onPhotoPublished(result.getId());
    }

    @Override
    public void onError(Exception exception) {
      view.showErrorWhileUploading();
    }
  }

  public interface View extends Presenter.View {
    void showUploading();

    void showErrorWhileUploading();

    void onPhotoPublished(String photoId);
  }
}
