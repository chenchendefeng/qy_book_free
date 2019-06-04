package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookDetailContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookDetailModule_ProvideAboutViewFactory
    implements Factory<BookDetailContract.View> {
  private final BookDetailModule module;

  public BookDetailModule_ProvideAboutViewFactory(BookDetailModule module) {
    this.module = module;
  }

  @Override
  public BookDetailContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookDetailModule_ProvideAboutViewFactory create(BookDetailModule module) {
    return new BookDetailModule_ProvideAboutViewFactory(module);
  }

  public static BookDetailContract.View proxyProvideAboutView(BookDetailModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
