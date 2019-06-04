package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_GetLinearLayoutManagerFactory
    implements Factory<LinearLayoutManager> {
  private final ClassificationModule module;

  public ClassificationModule_GetLinearLayoutManagerFactory(ClassificationModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.getLinearLayoutManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_GetLinearLayoutManagerFactory create(
      ClassificationModule module) {
    return new ClassificationModule_GetLinearLayoutManagerFactory(module);
  }

  public static LinearLayoutManager proxyGetLinearLayoutManager(ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.getLinearLayoutManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
