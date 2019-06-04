package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MyWalletContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyWalletModule_ProvideAboutViewFactory
    implements Factory<MyWalletContract.View> {
  private final MyWalletModule module;

  public MyWalletModule_ProvideAboutViewFactory(MyWalletModule module) {
    this.module = module;
  }

  @Override
  public MyWalletContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyWalletModule_ProvideAboutViewFactory create(MyWalletModule module) {
    return new MyWalletModule_ProvideAboutViewFactory(module);
  }

  public static MyWalletContract.View proxyProvideAboutView(MyWalletModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
