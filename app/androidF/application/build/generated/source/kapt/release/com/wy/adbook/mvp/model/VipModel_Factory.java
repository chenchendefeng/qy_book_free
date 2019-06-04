package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VipModel_Factory implements Factory<VipModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public VipModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public VipModel get() {
    return new VipModel(repositoryManagerProvider.get());
  }

  public static VipModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new VipModel_Factory(repositoryManagerProvider);
  }
}
