package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RedEnvelopesForCodeModel_Factory implements Factory<RedEnvelopesForCodeModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public RedEnvelopesForCodeModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public RedEnvelopesForCodeModel get() {
    return new RedEnvelopesForCodeModel(repositoryManagerProvider.get());
  }

  public static RedEnvelopesForCodeModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new RedEnvelopesForCodeModel_Factory(repositoryManagerProvider);
  }
}
