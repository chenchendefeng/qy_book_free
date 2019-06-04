package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutUsModel_Factory implements Factory<AboutUsModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public AboutUsModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public AboutUsModel get() {
    return new AboutUsModel(repositoryManagerProvider.get());
  }

  public static AboutUsModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new AboutUsModel_Factory(repositoryManagerProvider);
  }
}
