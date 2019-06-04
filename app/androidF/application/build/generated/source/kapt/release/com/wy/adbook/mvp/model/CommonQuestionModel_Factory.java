package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionModel_Factory implements Factory<CommonQuestionModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public CommonQuestionModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public CommonQuestionModel get() {
    return new CommonQuestionModel(repositoryManagerProvider.get());
  }

  public static CommonQuestionModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new CommonQuestionModel_Factory(repositoryManagerProvider);
  }
}
