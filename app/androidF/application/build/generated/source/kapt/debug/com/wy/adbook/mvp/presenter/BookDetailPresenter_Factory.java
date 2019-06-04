package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.BookDetailContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookDetailPresenter_Factory implements Factory<BookDetailPresenter> {
  private final Provider<BookDetailContract.Model> modelProvider;

  private final Provider<BookDetailContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BookDetailPresenter_Factory(
      Provider<BookDetailContract.Model> modelProvider,
      Provider<BookDetailContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public BookDetailPresenter get() {
    BookDetailPresenter instance = new BookDetailPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static BookDetailPresenter_Factory create(
      Provider<BookDetailContract.Model> modelProvider,
      Provider<BookDetailContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BookDetailPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static BookDetailPresenter newBookDetailPresenter(
      BookDetailContract.Model model, BookDetailContract.View view) {
    return new BookDetailPresenter(model, view);
  }
}
