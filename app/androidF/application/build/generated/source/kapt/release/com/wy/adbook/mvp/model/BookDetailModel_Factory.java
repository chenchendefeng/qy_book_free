package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookDetailModel_Factory implements Factory<BookDetailModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public BookDetailModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public BookDetailModel get() {
    return new BookDetailModel(repositoryManagerProvider.get());
  }

  public static BookDetailModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new BookDetailModel_Factory(repositoryManagerProvider);
  }
}
