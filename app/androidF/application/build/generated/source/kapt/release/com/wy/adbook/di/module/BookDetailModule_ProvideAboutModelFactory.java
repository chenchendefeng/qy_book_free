package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookDetailContract;
import com.wy.adbook.mvp.model.BookDetailModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookDetailModule_ProvideAboutModelFactory
    implements Factory<BookDetailContract.Model> {
  private final BookDetailModule module;

  private final Provider<BookDetailModel> modelProvider;

  public BookDetailModule_ProvideAboutModelFactory(
      BookDetailModule module, Provider<BookDetailModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public BookDetailContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookDetailModule_ProvideAboutModelFactory create(
      BookDetailModule module, Provider<BookDetailModel> modelProvider) {
    return new BookDetailModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static BookDetailContract.Model proxyProvideAboutModel(
      BookDetailModule instance, BookDetailModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
