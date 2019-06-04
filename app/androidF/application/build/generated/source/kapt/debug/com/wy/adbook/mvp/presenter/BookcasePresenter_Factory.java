package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.BookcaseContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookcasePresenter_Factory implements Factory<BookcasePresenter> {
  private final Provider<BookcaseContract.Model> modelProvider;

  private final Provider<BookcaseContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BookcasePresenter_Factory(
      Provider<BookcaseContract.Model> modelProvider,
      Provider<BookcaseContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public BookcasePresenter get() {
    BookcasePresenter instance = new BookcasePresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static BookcasePresenter_Factory create(
      Provider<BookcaseContract.Model> modelProvider,
      Provider<BookcaseContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BookcasePresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static BookcasePresenter newBookcasePresenter(
      BookcaseContract.Model model, BookcaseContract.View view) {
    return new BookcasePresenter(model, view);
  }
}
