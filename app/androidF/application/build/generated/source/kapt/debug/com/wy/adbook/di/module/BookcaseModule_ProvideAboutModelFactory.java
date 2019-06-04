package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookcaseContract;
import com.wy.adbook.mvp.model.BookcaseModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookcaseModule_ProvideAboutModelFactory
    implements Factory<BookcaseContract.Model> {
  private final BookcaseModule module;

  private final Provider<BookcaseModel> modelProvider;

  public BookcaseModule_ProvideAboutModelFactory(
      BookcaseModule module, Provider<BookcaseModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public BookcaseContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookcaseModule_ProvideAboutModelFactory create(
      BookcaseModule module, Provider<BookcaseModel> modelProvider) {
    return new BookcaseModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static BookcaseContract.Model proxyProvideAboutModel(
      BookcaseModule instance, BookcaseModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
