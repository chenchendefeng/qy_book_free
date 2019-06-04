package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterModel_Factory implements Factory<HelpCenterModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public HelpCenterModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public HelpCenterModel get() {
    return new HelpCenterModel(repositoryManagerProvider.get());
  }

  public static HelpCenterModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new HelpCenterModel_Factory(repositoryManagerProvider);
  }
}
