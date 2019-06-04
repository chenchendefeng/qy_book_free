package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookCityContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookCityModule_ProvideAboutViewFactory
    implements Factory<BookCityContract.View> {
  private final BookCityModule module;

  public BookCityModule_ProvideAboutViewFactory(BookCityModule module) {
    this.module = module;
  }

  @Override
  public BookCityContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookCityModule_ProvideAboutViewFactory create(BookCityModule module) {
    return new BookCityModule_ProvideAboutViewFactory(module);
  }

  public static BookCityContract.View proxyProvideAboutView(BookCityModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
