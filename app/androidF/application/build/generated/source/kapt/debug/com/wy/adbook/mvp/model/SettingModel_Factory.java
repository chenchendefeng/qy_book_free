package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingModel_Factory implements Factory<SettingModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public SettingModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public SettingModel get() {
    return new SettingModel(repositoryManagerProvider.get());
  }

  public static SettingModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new SettingModel_Factory(repositoryManagerProvider);
  }
}
