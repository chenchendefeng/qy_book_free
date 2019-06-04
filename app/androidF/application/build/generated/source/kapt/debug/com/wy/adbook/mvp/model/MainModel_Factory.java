package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModel_Factory implements Factory<MainModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public MainModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public MainModel get() {
    return new MainModel(repositoryManagerProvider.get());
  }

  public static MainModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new MainModel_Factory(repositoryManagerProvider);
  }
}
