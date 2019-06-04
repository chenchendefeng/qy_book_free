package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WithdrawalRecordContract;
import com.wy.adbook.mvp.model.WithdrawalRecordModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordModule_ProvideAboutModelFactory
    implements Factory<WithdrawalRecordContract.Model> {
  private final WithdrawalRecordModule module;

  private final Provider<WithdrawalRecordModel> modelProvider;

  public WithdrawalRecordModule_ProvideAboutModelFactory(
      WithdrawalRecordModule module, Provider<WithdrawalRecordModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public WithdrawalRecordContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalRecordModule_ProvideAboutModelFactory create(
      WithdrawalRecordModule module, Provider<WithdrawalRecordModel> modelProvider) {
    return new WithdrawalRecordModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static WithdrawalRecordContract.Model proxyProvideAboutModel(
      WithdrawalRecordModule instance, WithdrawalRecordModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
