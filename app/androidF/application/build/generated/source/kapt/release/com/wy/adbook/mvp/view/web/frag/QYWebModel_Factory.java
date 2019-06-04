package com.wy.adbook.mvp.view.web.frag;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebModel_Factory implements Factory<QYWebModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public QYWebModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public QYWebModel get() {
    return new QYWebModel(repositoryManagerProvider.get());
  }

  public static QYWebModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new QYWebModel_Factory(repositoryManagerProvider);
  }
}
