package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModel_Factory implements Factory<ClassificationModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public ClassificationModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public ClassificationModel get() {
    return new ClassificationModel(repositoryManagerProvider.get());
  }

  public static ClassificationModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new ClassificationModel_Factory(repositoryManagerProvider);
  }
}
