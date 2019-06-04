package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MainContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideAboutViewFactory implements Factory<MainContract.View> {
  private final MainModule module;

  public MainModule_ProvideAboutViewFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public MainContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MainModule_ProvideAboutViewFactory create(MainModule module) {
    return new MainModule_ProvideAboutViewFactory(module);
  }

  public static MainContract.View proxyProvideAboutView(MainModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
