package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendModel_Factory implements Factory<MyFriendModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public MyFriendModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public MyFriendModel get() {
    return new MyFriendModel(repositoryManagerProvider.get());
  }

  public static MyFriendModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new MyFriendModel_Factory(repositoryManagerProvider);
  }
}
