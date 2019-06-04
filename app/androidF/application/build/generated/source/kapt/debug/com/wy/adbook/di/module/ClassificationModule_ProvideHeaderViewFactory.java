package com.wy.adbook.di.module;

import android.view.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideHeaderViewFactory implements Factory<View> {
  private final ClassificationModule module;

  public ClassificationModule_ProvideHeaderViewFactory(ClassificationModule module) {
    this.module = module;
  }

  @Override
  public View get() {
    return Preconditions.checkNotNull(
        module.provideHeaderView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideHeaderViewFactory create(ClassificationModule module) {
    return new ClassificationModule_ProvideHeaderViewFactory(module);
  }

  public static View proxyProvideHeaderView(ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideHeaderView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
