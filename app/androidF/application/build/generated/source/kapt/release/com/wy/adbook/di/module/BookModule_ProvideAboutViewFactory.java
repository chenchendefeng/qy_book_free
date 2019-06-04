package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookModule_ProvideAboutViewFactory implements Factory<BookContract.View> {
  private final BookModule module;

  public BookModule_ProvideAboutViewFactory(BookModule module) {
    this.module = module;
  }

  @Override
  public BookContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookModule_ProvideAboutViewFactory create(BookModule module) {
    return new BookModule_ProvideAboutViewFactory(module);
  }

  public static BookContract.View proxyProvideAboutView(BookModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
