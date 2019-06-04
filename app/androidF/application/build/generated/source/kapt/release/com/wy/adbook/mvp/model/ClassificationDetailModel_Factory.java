package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationDetailModel_Factory implements Factory<ClassificationDetailModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public ClassificationDetailModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public ClassificationDetailModel get() {
    return new ClassificationDetailModel(repositoryManagerProvider.get());
  }

  public static ClassificationDetailModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new ClassificationDetailModel_Factory(repositoryManagerProvider);
  }
}
