package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RedEnvelopesForCodeModule_ProvideAboutViewFactory
    implements Factory<RedEnvelopesForCodeContract.View> {
  private final RedEnvelopesForCodeModule module;

  public RedEnvelopesForCodeModule_ProvideAboutViewFactory(RedEnvelopesForCodeModule module) {
    this.module = module;
  }

  @Override
  public RedEnvelopesForCodeContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static RedEnvelopesForCodeModule_ProvideAboutViewFactory create(
      RedEnvelopesForCodeModule module) {
    return new RedEnvelopesForCodeModule_ProvideAboutViewFactory(module);
  }

  public static RedEnvelopesForCodeContract.View proxyProvideAboutView(
      RedEnvelopesForCodeModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
