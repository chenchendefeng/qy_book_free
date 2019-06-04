package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ProjectContract;
import com.wy.adbook.mvp.model.ProjectModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModule_ProvideAboutModelFactory
    implements Factory<ProjectContract.Model> {
  private final ProjectModule module;

  private final Provider<ProjectModel> modelProvider;

  public ProjectModule_ProvideAboutModelFactory(
      ProjectModule module, Provider<ProjectModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public ProjectContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_ProvideAboutModelFactory create(
      ProjectModule module, Provider<ProjectModel> modelProvider) {
    return new ProjectModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static ProjectContract.Model proxyProvideAboutModel(
      ProjectModule instance, ProjectModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
