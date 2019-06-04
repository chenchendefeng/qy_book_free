package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.AboutUsContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutUsModule_ProvideAboutViewFactory implements Factory<AboutUsContract.View> {
  private final AboutUsModule module;

  public AboutUsModule_ProvideAboutViewFactory(AboutUsModule module) {
    this.module = module;
  }

  @Override
  public AboutUsContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AboutUsModule_ProvideAboutViewFactory create(AboutUsModule module) {
    return new AboutUsModule_ProvideAboutViewFactory(module);
  }

  public static AboutUsContract.View proxyProvideAboutView(AboutUsModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
