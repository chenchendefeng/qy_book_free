package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoveAdSuccessModule_ProvideAboutViewFactory
    implements Factory<RemoveAdSuccessContract.View> {
  private final RemoveAdSuccessModule module;

  public RemoveAdSuccessModule_ProvideAboutViewFactory(RemoveAdSuccessModule module) {
    this.module = module;
  }

  @Override
  public RemoveAdSuccessContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static RemoveAdSuccessModule_ProvideAboutViewFactory create(RemoveAdSuccessModule module) {
    return new RemoveAdSuccessModule_ProvideAboutViewFactory(module);
  }

  public static RemoveAdSuccessContract.View proxyProvideAboutView(RemoveAdSuccessModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
