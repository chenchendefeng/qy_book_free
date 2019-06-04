package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WalletItemContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletItemModule_ProvideAboutViewFactory
    implements Factory<WalletItemContract.View> {
  private final WalletItemModule module;

  public WalletItemModule_ProvideAboutViewFactory(WalletItemModule module) {
    this.module = module;
  }

  @Override
  public WalletItemContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WalletItemModule_ProvideAboutViewFactory create(WalletItemModule module) {
    return new WalletItemModule_ProvideAboutViewFactory(module);
  }

  public static WalletItemContract.View proxyProvideAboutView(WalletItemModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
