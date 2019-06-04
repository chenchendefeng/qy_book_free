package com.wy.adbook.di.module;

import android.view.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModule_HeaderViewFactory implements Factory<View> {
  private final ProjectModule module;

  public ProjectModule_HeaderViewFactory(ProjectModule module) {
    this.module = module;
  }

  @Override
  public View get() {
    return Preconditions.checkNotNull(
        module.headerView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_HeaderViewFactory create(ProjectModule module) {
    return new ProjectModule_HeaderViewFactory(module);
  }

  public static View proxyHeaderView(ProjectModule instance) {
    return Preconditions.checkNotNull(
        instance.headerView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
