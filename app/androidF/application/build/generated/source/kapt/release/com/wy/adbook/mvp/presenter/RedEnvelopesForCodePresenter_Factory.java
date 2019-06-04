package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RedEnvelopesForCodePresenter_Factory
    implements Factory<RedEnvelopesForCodePresenter> {
  private final Provider<RedEnvelopesForCodeContract.Model> modelProvider;

  private final Provider<RedEnvelopesForCodeContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public RedEnvelopesForCodePresenter_Factory(
      Provider<RedEnvelopesForCodeContract.Model> modelProvider,
      Provider<RedEnvelopesForCodeContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public RedEnvelopesForCodePresenter get() {
    RedEnvelopesForCodePresenter instance =
        new RedEnvelopesForCodePresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static RedEnvelopesForCodePresenter_Factory create(
      Provider<RedEnvelopesForCodeContract.Model> modelProvider,
      Provider<RedEnvelopesForCodeContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new RedEnvelopesForCodePresenter_Factory(
        modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static RedEnvelopesForCodePresenter newRedEnvelopesForCodePresenter(
      RedEnvelopesForCodeContract.Model model, RedEnvelopesForCodeContract.View view) {
    return new RedEnvelopesForCodePresenter(model, view);
  }
}
