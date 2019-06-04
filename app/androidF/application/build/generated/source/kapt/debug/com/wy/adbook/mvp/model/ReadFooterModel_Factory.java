package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterModel_Factory implements Factory<ReadFooterModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public ReadFooterModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public ReadFooterModel get() {
    return new ReadFooterModel(repositoryManagerProvider.get());
  }

  public static ReadFooterModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new ReadFooterModel_Factory(repositoryManagerProvider);
  }
}
