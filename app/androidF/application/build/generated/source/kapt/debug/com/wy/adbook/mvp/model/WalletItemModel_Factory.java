package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletItemModel_Factory implements Factory<WalletItemModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public WalletItemModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public WalletItemModel get() {
    return new WalletItemModel(repositoryManagerProvider.get());
  }

  public static WalletItemModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new WalletItemModel_Factory(repositoryManagerProvider);
  }
}
