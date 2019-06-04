package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookCityModel_Factory implements Factory<BookCityModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public BookCityModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public BookCityModel get() {
    return new BookCityModel(repositoryManagerProvider.get());
  }

  public static BookCityModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new BookCityModel_Factory(repositoryManagerProvider);
  }
}
