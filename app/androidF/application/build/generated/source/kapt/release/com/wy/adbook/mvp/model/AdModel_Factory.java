package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdModel_Factory implements Factory<AdModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public AdModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public AdModel get() {
    return new AdModel(repositoryManagerProvider.get());
  }

  public static AdModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new AdModel_Factory(repositoryManagerProvider);
  }
}
