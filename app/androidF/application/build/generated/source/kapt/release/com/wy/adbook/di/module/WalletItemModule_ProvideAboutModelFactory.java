package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WalletItemContract;
import com.wy.adbook.mvp.model.WalletItemModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletItemModule_ProvideAboutModelFactory
    implements Factory<WalletItemContract.Model> {
  private final WalletItemModule module;

  private final Provider<WalletItemModel> modelProvider;

  public WalletItemModule_ProvideAboutModelFactory(
      WalletItemModule module, Provider<WalletItemModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public WalletItemContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WalletItemModule_ProvideAboutModelFactory create(
      WalletItemModule module, Provider<WalletItemModel> modelProvider) {
    return new WalletItemModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static WalletItemContract.Model proxyProvideAboutModel(
      WalletItemModule instance, WalletItemModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
