package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.IWelcomeContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomeModule_ProvideAboutViewFactory implements Factory<IWelcomeContract.View> {
  private final WelcomeModule module;

  public WelcomeModule_ProvideAboutViewFactory(WelcomeModule module) {
    this.module = module;
  }

  @Override
  public IWelcomeContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WelcomeModule_ProvideAboutViewFactory create(WelcomeModule module) {
    return new WelcomeModule_ProvideAboutViewFactory(module);
  }

  public static IWelcomeContract.View proxyProvideAboutView(WelcomeModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
