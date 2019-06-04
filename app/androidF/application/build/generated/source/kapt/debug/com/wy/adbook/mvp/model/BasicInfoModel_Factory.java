package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoModel_Factory implements Factory<BasicInfoModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public BasicInfoModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public BasicInfoModel get() {
    return new BasicInfoModel(repositoryManagerProvider.get());
  }

  public static BasicInfoModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new BasicInfoModel_Factory(repositoryManagerProvider);
  }
}
