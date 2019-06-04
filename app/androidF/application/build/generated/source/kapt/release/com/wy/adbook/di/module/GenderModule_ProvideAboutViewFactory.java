package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.GenderContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GenderModule_ProvideAboutViewFactory implements Factory<GenderContract.View> {
  private final GenderModule module;

  public GenderModule_ProvideAboutViewFactory(GenderModule module) {
    this.module = module;
  }

  @Override
  public GenderContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static GenderModule_ProvideAboutViewFactory create(GenderModule module) {
    return new GenderModule_ProvideAboutViewFactory(module);
  }

  public static GenderContract.View proxyProvideAboutView(GenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
