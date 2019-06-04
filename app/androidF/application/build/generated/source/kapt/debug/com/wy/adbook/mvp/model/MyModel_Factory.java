package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyModel_Factory implements Factory<MyModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public MyModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public MyModel get() {
    return new MyModel(repositoryManagerProvider.get());
  }

  public static MyModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new MyModel_Factory(repositoryManagerProvider);
  }
}
