package com.wy.adbook.mvp.view.web.act;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebModel_Factory implements Factory<WebModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public WebModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public WebModel get() {
    return new WebModel(repositoryManagerProvider.get());
  }

  public static WebModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new WebModel_Factory(repositoryManagerProvider);
  }
}
