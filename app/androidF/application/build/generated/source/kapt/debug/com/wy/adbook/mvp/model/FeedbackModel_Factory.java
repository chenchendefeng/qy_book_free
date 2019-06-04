package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedbackModel_Factory implements Factory<FeedbackModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public FeedbackModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public FeedbackModel get() {
    return new FeedbackModel(repositoryManagerProvider.get());
  }

  public static FeedbackModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new FeedbackModel_Factory(repositoryManagerProvider);
  }
}
