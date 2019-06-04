package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.adapter.ProjectItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModule_ProvideProjectListFactory implements Factory<List<ProjectItem>> {
  private final ProjectModule module;

  public ProjectModule_ProvideProjectListFactory(ProjectModule module) {
    this.module = module;
  }

  @Override
  public List<ProjectItem> get() {
    return Preconditions.checkNotNull(
        module.provideProjectList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_ProvideProjectListFactory create(ProjectModule module) {
    return new ProjectModule_ProvideProjectListFactory(module);
  }

  public static List<ProjectItem> proxyProvideProjectList(ProjectModule instance) {
    return Preconditions.checkNotNull(
        instance.provideProjectList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
