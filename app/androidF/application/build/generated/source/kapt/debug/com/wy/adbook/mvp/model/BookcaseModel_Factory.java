package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookcaseModel_Factory implements Factory<BookcaseModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public BookcaseModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public BookcaseModel get() {
    return new BookcaseModel(repositoryManagerProvider.get());
  }

  public static BookcaseModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new BookcaseModel_Factory(repositoryManagerProvider);
  }
}
