package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchModel_Factory implements Factory<SearchModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public SearchModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public SearchModel get() {
    return new SearchModel(repositoryManagerProvider.get());
  }

  public static SearchModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new SearchModel_Factory(repositoryManagerProvider);
  }
}
