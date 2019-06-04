package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FaceToFaceModel_Factory implements Factory<FaceToFaceModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public FaceToFaceModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public FaceToFaceModel get() {
    return new FaceToFaceModel(repositoryManagerProvider.get());
  }

  public static FaceToFaceModel_Factory create(
      Provider<IRepositoryManager> repositoryManagerProvider) {
    return new FaceToFaceModel_Factory(repositoryManagerProvider);
  }
}
