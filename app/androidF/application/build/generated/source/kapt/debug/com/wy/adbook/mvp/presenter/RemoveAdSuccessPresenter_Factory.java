package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoveAdSuccessPresenter_Factory implements Factory<RemoveAdSuccessPresenter> {
  private final Provider<RemoveAdSuccessContract.Model> modelProvider;

  private final Provider<RemoveAdSuccessContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public RemoveAdSuccessPresenter_Factory(
      Provider<RemoveAdSuccessContract.Model> modelProvider,
      Provider<RemoveAdSuccessContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public RemoveAdSuccessPresenter get() {
    RemoveAdSuccessPresenter instance =
        new RemoveAdSuccessPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static RemoveAdSuccessPresenter_Factory create(
      Provider<RemoveAdSuccessContract.Model> modelProvider,
      Provider<RemoveAdSuccessContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new RemoveAdSuccessPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static RemoveAdSuccessPresenter newRemoveAdSuccessPresenter(
      RemoveAdSuccessContract.Model model, RemoveAdSuccessContract.View view) {
    return new RemoveAdSuccessPresenter(model, view);
  }
}
