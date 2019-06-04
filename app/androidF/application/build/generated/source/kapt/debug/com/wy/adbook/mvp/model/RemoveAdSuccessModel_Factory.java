package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoveAdSuccessModel_Factory implements Factory<RemoveAdSuccessModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public RemoveAdSuccessModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public RemoveAdSuccessModel get() {
    return new RemoveAdSuccessModel(repositoryManagerProvider.get());
  }

  public static RemoveAdSuccessModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new RemoveAdSuccessModel_Factory(repositoryManagerProvider);
  }
}
