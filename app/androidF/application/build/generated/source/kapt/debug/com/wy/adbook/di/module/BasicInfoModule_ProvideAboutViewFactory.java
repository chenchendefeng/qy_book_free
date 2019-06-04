package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BasicInfoContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoModule_ProvideAboutViewFactory
    implements Factory<BasicInfoContract.View> {
  private final BasicInfoModule module;

  public BasicInfoModule_ProvideAboutViewFactory(BasicInfoModule module) {
    this.module = module;
  }

  @Override
  public BasicInfoContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BasicInfoModule_ProvideAboutViewFactory create(BasicInfoModule module) {
    return new BasicInfoModule_ProvideAboutViewFactory(module);
  }

  public static BasicInfoContract.View proxyProvideAboutView(BasicInfoModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
