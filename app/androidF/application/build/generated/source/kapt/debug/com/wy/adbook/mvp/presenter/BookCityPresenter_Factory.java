package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.BookCityContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookCityPresenter_Factory implements Factory<BookCityPresenter> {
  private final Provider<BookCityContract.Model> modelProvider;

  private final Provider<BookCityContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BookCityPresenter_Factory(
      Provider<BookCityContract.Model> modelProvider,
      Provider<BookCityContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public BookCityPresenter get() {
    BookCityPresenter instance = new BookCityPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static BookCityPresenter_Factory create(
      Provider<BookCityContract.Model> modelProvider,
      Provider<BookCityContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BookCityPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static BookCityPresenter newBookCityPresenter(
      BookCityContract.Model model, BookCityContract.View view) {
    return new BookCityPresenter(model, view);
  }
}
