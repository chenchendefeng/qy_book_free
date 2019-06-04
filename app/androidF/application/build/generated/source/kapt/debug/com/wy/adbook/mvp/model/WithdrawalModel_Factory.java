package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalModel_Factory implements Factory<WithdrawalModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public WithdrawalModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public WithdrawalModel get() {
    return new WithdrawalModel(repositoryManagerProvider.get());
  }

  public static WithdrawalModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new WithdrawalModel_Factory(repositoryManagerProvider);
  }
}
