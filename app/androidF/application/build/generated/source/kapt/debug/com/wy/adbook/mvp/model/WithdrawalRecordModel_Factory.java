package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordModel_Factory implements Factory<WithdrawalRecordModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public WithdrawalRecordModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public WithdrawalRecordModel get() {
    return new WithdrawalRecordModel(repositoryManagerProvider.get());
  }

  public static WithdrawalRecordModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new WithdrawalRecordModel_Factory(repositoryManagerProvider);
  }
}
