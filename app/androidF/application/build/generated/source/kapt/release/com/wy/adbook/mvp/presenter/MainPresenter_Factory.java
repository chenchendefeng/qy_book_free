package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.MainContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_Factory implements Factory<MainPresenter> {
  private final Provider<MainContract.Model> modelProvider;

  private final Provider<MainContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public MainPresenter_Factory(
      Provider<MainContract.Model> modelProvider,
      Provider<MainContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public MainPresenter get() {
    MainPresenter instance = new MainPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static MainPresenter_Factory create(
      Provider<MainContract.Model> modelProvider,
      Provider<MainContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new MainPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static MainPresenter newMainPresenter(MainContract.Model model, MainContract.View view) {
    return new MainPresenter(model, view);
  }
}
