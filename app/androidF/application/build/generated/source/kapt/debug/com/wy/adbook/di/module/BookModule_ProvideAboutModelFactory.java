package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookContract;
import com.wy.adbook.mvp.model.BookModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookModule_ProvideAboutModelFactory implements Factory<BookContract.Model> {
  private final BookModule module;

  private final Provider<BookModel> modelProvider;

  public BookModule_ProvideAboutModelFactory(BookModule module, Provider<BookModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public BookContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookModule_ProvideAboutModelFactory create(
      BookModule module, Provider<BookModel> modelProvider) {
    return new BookModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static BookContract.Model proxyProvideAboutModel(BookModule instance, BookModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
