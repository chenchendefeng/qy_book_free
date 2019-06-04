package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadModel_Factory implements Factory<ReadModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public ReadModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public ReadModel get() {
    return new ReadModel(repositoryManagerProvider.get());
  }

  public static ReadModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new ReadModel_Factory(repositoryManagerProvider);
  }
}
