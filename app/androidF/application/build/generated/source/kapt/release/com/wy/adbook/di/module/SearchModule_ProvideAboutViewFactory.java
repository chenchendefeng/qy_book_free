package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.SearchContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchModule_ProvideAboutViewFactory implements Factory<SearchContract.View> {
  private final SearchModule module;

  public SearchModule_ProvideAboutViewFactory(SearchModule module) {
    this.module = module;
  }

  @Override
  public SearchContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SearchModule_ProvideAboutViewFactory create(SearchModule module) {
    return new SearchModule_ProvideAboutViewFactory(module);
  }

  public static SearchContract.View proxyProvideAboutView(SearchModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
