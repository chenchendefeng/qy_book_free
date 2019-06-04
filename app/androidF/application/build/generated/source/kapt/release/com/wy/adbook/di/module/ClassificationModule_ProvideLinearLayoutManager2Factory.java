package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideLinearLayoutManager2Factory
    implements Factory<LinearLayoutManager> {
  private final ClassificationModule module;

  public ClassificationModule_ProvideLinearLayoutManager2Factory(ClassificationModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.provideLinearLayoutManager2(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideLinearLayoutManager2Factory create(
      ClassificationModule module) {
    return new ClassificationModule_ProvideLinearLayoutManager2Factory(module);
  }

  public static LinearLayoutManager proxyProvideLinearLayoutManager2(
      ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideLinearLayoutManager2(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
