package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WithdrawalContract;
import com.wy.adbook.mvp.model.WithdrawalModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalModule_ProvideAboutModelFactory
    implements Factory<WithdrawalContract.Model> {
  private final WithdrawalModule module;

  private final Provider<WithdrawalModel> modelProvider;

  public WithdrawalModule_ProvideAboutModelFactory(
      WithdrawalModule module, Provider<WithdrawalModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public WithdrawalContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalModule_ProvideAboutModelFactory create(
      WithdrawalModule module, Provider<WithdrawalModel> modelProvider) {
    return new WithdrawalModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static WithdrawalContract.Model proxyProvideAboutModel(
      WithdrawalModule instance, WithdrawalModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
