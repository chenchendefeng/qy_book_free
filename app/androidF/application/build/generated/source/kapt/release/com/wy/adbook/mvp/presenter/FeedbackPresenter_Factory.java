package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.FeedbackContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedbackPresenter_Factory implements Factory<FeedbackPresenter> {
  private final Provider<FeedbackContract.Model> modelProvider;

  private final Provider<FeedbackContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public FeedbackPresenter_Factory(
      Provider<FeedbackContract.Model> modelProvider,
      Provider<FeedbackContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public FeedbackPresenter get() {
    FeedbackPresenter instance = new FeedbackPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static FeedbackPresenter_Factory create(
      Provider<FeedbackContract.Model> modelProvider,
      Provider<FeedbackContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new FeedbackPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static FeedbackPresenter newFeedbackPresenter(
      FeedbackContract.Model model, FeedbackContract.View view) {
    return new FeedbackPresenter(model, view);
  }
}
