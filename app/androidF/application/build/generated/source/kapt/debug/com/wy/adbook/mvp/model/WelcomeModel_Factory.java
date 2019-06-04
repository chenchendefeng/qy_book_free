package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomeModel_Factory implements Factory<WelcomeModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public WelcomeModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public WelcomeModel get() {
    return new WelcomeModel(repositoryManagerProvider.get());
  }

  public static WelcomeModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new WelcomeModel_Factory(repositoryManagerProvider);
  }
}
