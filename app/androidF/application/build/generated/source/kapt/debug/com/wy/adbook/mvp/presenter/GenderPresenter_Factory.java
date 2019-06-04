package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.GenderContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GenderPresenter_Factory implements Factory<GenderPresenter> {
  private final Provider<GenderContract.Model> modelProvider;

  private final Provider<GenderContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public GenderPresenter_Factory(
      Provider<GenderContract.Model> modelProvider,
      Provider<GenderContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public GenderPresenter get() {
    GenderPresenter instance = new GenderPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static GenderPresenter_Factory create(
      Provider<GenderContract.Model> modelProvider,
      Provider<GenderContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new GenderPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static GenderPresenter newGenderPresenter(
      GenderContract.Model model, GenderContract.View view) {
    return new GenderPresenter(model, view);
  }
}
