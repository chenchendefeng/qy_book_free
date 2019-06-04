package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelfareModel_Factory implements Factory<WelfareModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public WelfareModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public WelfareModel get() {
    return new WelfareModel(repositoryManagerProvider.get());
  }

  public static WelfareModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new WelfareModel_Factory(repositoryManagerProvider);
  }
}
