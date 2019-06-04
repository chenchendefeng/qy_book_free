package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookModel_Factory implements Factory<BookModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public BookModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public BookModel get() {
    return new BookModel(repositoryManagerProvider.get());
  }

  public static BookModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new BookModel_Factory(repositoryManagerProvider);
  }
}
