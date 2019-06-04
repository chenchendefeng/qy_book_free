package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginModel_Factory implements Factory<LoginModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public LoginModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public LoginModel get() {
    return new LoginModel(repositoryManagerProvider.get());
  }

  public static LoginModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new LoginModel_Factory(repositoryManagerProvider);
  }
}
