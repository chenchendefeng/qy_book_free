package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectModule_ProvideLayoutManager1Factory
    implements Factory<LinearLayoutManager> {
  private final ProjectModule module;

  public ProjectModule_ProvideLayoutManager1Factory(ProjectModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.provideLayoutManager1(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_ProvideLayoutManager1Factory create(ProjectModule module) {
    return new ProjectModule_ProvideLayoutManager1Factory(module);
  }

  public static LinearLayoutManager proxyProvideLayoutManager1(ProjectModule instance) {
    return Preconditions.checkNotNull(
        instance.provideLayoutManager1(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
