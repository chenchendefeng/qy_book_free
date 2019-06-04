package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.BookContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookPresenter_Factory implements Factory<BookPresenter> {
  private final Provider<BookContract.Model> modelProvider;

  private final Provider<BookContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BookPresenter_Factory(
      Provider<BookContract.Model> modelProvider,
      Provider<BookContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public BookPresenter get() {
    BookPresenter instance = new BookPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static BookPresenter_Factory create(
      Provider<BookContract.Model> modelProvider,
      Provider<BookContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BookPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static BookPresenter newBookPresenter(BookContract.Model model, BookContract.View view) {
    return new BookPresenter(model, view);
  }
}
