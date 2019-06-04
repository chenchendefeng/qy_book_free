package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookCityContract;
import com.wy.adbook.mvp.model.BookCityModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookCityModule_ProvideAboutModelFactory
    implements Factory<BookCityContract.Model> {
  private final BookCityModule module;

  private final Provider<BookCityModel> modelProvider;

  public BookCityModule_ProvideAboutModelFactory(
      BookCityModule module, Provider<BookCityModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public BookCityContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookCityModule_ProvideAboutModelFactory create(
      BookCityModule module, Provider<BookCityModel> modelProvider) {
    return new BookCityModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static BookCityContract.Model proxyProvideAboutModel(
      BookCityModule instance, BookCityModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
