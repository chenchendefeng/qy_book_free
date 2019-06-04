package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WithdrawalContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalModule_ProvideAboutViewFactory
    implements Factory<WithdrawalContract.View> {
  private final WithdrawalModule module;

  public WithdrawalModule_ProvideAboutViewFactory(WithdrawalModule module) {
    this.module = module;
  }

  @Override
  public WithdrawalContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalModule_ProvideAboutViewFactory create(WithdrawalModule module) {
    return new WithdrawalModule_ProvideAboutViewFactory(module);
  }

  public static WithdrawalContract.View proxyProvideAboutView(WithdrawalModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
