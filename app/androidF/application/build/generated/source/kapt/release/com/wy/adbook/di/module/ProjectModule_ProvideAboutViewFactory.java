package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ProjectContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModule_ProvideAboutViewFactory implements Factory<ProjectContract.View> {
  private final ProjectModule module;

  public ProjectModule_ProvideAboutViewFactory(ProjectModule module) {
    this.module = module;
  }

  @Override
  public ProjectContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_ProvideAboutViewFactory create(ProjectModule module) {
    return new ProjectModule_ProvideAboutViewFactory(module);
  }

  public static ProjectContract.View proxyProvideAboutView(ProjectModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
