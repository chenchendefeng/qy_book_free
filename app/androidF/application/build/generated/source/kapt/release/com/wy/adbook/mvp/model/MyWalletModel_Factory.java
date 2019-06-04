package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyWalletModel_Factory implements Factory<MyWalletModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public MyWalletModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public MyWalletModel get() {
    return new MyWalletModel(repositoryManagerProvider.get());
  }

  public static MyWalletModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new MyWalletModel_Factory(repositoryManagerProvider);
  }
}
