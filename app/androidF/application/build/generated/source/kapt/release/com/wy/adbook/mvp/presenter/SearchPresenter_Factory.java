package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.SearchContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchPresenter_Factory implements Factory<SearchPresenter> {
  private final Provider<SearchContract.Model> modelProvider;

  private final Provider<SearchContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public SearchPresenter_Factory(
      Provider<SearchContract.Model> modelProvider,
      Provider<SearchContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public SearchPresenter get() {
    SearchPresenter instance = new SearchPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static SearchPresenter_Factory create(
      Provider<SearchContract.Model> modelProvider,
      Provider<SearchContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new SearchPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static SearchPresenter newSearchPresenter(
      SearchContract.Model model, SearchContract.View view) {
    return new SearchPresenter(model, view);
  }
}
