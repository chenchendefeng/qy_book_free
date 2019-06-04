package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.AdContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdModule_ProvideAboutViewFactory implements Factory<AdContract.View> {
  private final AdModule module;

  public AdModule_ProvideAboutViewFactory(AdModule module) {
    this.module = module;
  }

  @Override
  public AdContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AdModule_ProvideAboutViewFactory create(AdModule module) {
    return new AdModule_ProvideAboutViewFactory(module);
  }

  public static AdContract.View proxyProvideAboutView(AdModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
