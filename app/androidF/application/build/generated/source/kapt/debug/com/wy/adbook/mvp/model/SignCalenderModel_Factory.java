package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModel_Factory implements Factory<SignCalenderModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public SignCalenderModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public SignCalenderModel get() {
    return new SignCalenderModel(repositoryManagerProvider.get());
  }

  public static SignCalenderModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new SignCalenderModel_Factory(repositoryManagerProvider);
  }
}
