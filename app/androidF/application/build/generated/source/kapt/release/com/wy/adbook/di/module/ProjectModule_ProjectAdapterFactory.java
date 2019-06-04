package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.adapter.ProjectAdapter;
import com.wy.adbook.mvp.view.adapter.ProjectItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModule_ProjectAdapterFactory implements Factory<ProjectAdapter> {
  private final ProjectModule module;

  private final Provider<List<ProjectItem>> listProvider;

  public ProjectModule_ProjectAdapterFactory(
      ProjectModule module, Provider<List<ProjectItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public ProjectAdapter get() {
    return Preconditions.checkNotNull(
        module.projectAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_ProjectAdapterFactory create(
      ProjectModule module, Provider<List<ProjectItem>> listProvider) {
    return new ProjectModule_ProjectAdapterFactory(module, listProvider);
  }

  public static ProjectAdapter proxyProjectAdapter(ProjectModule instance, List<ProjectItem> list) {
    return Preconditions.checkNotNull(
        instance.projectAdapter(list), "Cannot return null from a non-@Nullable @Provides method");
  }
}
