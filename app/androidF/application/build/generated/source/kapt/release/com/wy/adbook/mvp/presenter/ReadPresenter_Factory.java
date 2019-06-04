package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.ReadContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadPresenter_Factory implements Factory<ReadPresenter> {
  private final Provider<ReadContract.Model> modelProvider;

  private final Provider<ReadContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public ReadPresenter_Factory(
      Provider<ReadContract.Model> modelProvider,
      Provider<ReadContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public ReadPresenter get() {
    ReadPresenter instance = new ReadPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static ReadPresenter_Factory create(
      Provider<ReadContract.Model> modelProvider,
      Provider<ReadContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new ReadPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static ReadPresenter newReadPresenter(ReadContract.Model model, ReadContract.View view) {
    return new ReadPresenter(model, view);
  }
}
