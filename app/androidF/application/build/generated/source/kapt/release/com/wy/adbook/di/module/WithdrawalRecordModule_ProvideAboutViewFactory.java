package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WithdrawalRecordContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordModule_ProvideAboutViewFactory
    implements Factory<WithdrawalRecordContract.View> {
  private final WithdrawalRecordModule module;

  public WithdrawalRecordModule_ProvideAboutViewFactory(WithdrawalRecordModule module) {
    this.module = module;
  }

  @Override
  public WithdrawalRecordContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalRecordModule_ProvideAboutViewFactory create(
      WithdrawalRecordModule module) {
    return new WithdrawalRecordModule_ProvideAboutViewFactory(module);
  }

  public static WithdrawalRecordContract.View proxyProvideAboutView(
      WithdrawalRecordModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
