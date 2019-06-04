package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModel_Factory implements Factory<ProjectModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public ProjectModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public ProjectModel get() {
    return new ProjectModel(repositoryManagerProvider.get());
  }

  public static ProjectModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new ProjectModel_Factory(repositoryManagerProvider);
  }
}
