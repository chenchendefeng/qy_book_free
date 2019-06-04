package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.VipContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VipModule_ProvideAboutViewFactory implements Factory<VipContract.View> {
  private final VipModule module;

  public VipModule_ProvideAboutViewFactory(VipModule module) {
    this.module = module;
  }

  @Override
  public VipContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static VipModule_ProvideAboutViewFactory create(VipModule module) {
    return new VipModule_ProvideAboutViewFactory(module);
  }

  public static VipContract.View proxyProvideAboutView(VipModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
