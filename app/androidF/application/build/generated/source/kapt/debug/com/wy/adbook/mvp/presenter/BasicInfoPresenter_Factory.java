package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.BasicInfoContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoPresenter_Factory implements Factory<BasicInfoPresenter> {
  private final Provider<BasicInfoContract.Model> modelProvider;

  private final Provider<BasicInfoContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BasicInfoPresenter_Factory(
      Provider<BasicInfoContract.Model> modelProvider,
      Provider<BasicInfoContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public BasicInfoPresenter get() {
    BasicInfoPresenter instance = new BasicInfoPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static BasicInfoPresenter_Factory create(
      Provider<BasicInfoContract.Model> modelProvider,
      Provider<BasicInfoContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BasicInfoPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static BasicInfoPresenter newBasicInfoPresenter(
      BasicInfoContract.Model model, BasicInfoContract.View view) {
    return new BasicInfoPresenter(model, view);
  }
}
