package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BookcaseContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookcaseModule_ProvideAboutViewFactory
    implements Factory<BookcaseContract.View> {
  private final BookcaseModule module;

  public BookcaseModule_ProvideAboutViewFactory(BookcaseModule module) {
    this.module = module;
  }

  @Override
  public BookcaseContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BookcaseModule_ProvideAboutViewFactory create(BookcaseModule module) {
    return new BookcaseModule_ProvideAboutViewFactory(module);
  }

  public static BookcaseContract.View proxyProvideAboutView(BookcaseModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
