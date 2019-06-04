package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideClassificationContentAdapterFactory
    implements Factory<ClassificationContentAdapter> {
  private final ClassificationModule module;

  public ClassificationModule_ProvideClassificationContentAdapterFactory(
      ClassificationModule module) {
    this.module = module;
  }

  @Override
  public ClassificationContentAdapter get() {
    return Preconditions.checkNotNull(
        module.provideClassificationContentAdapter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideClassificationContentAdapterFactory create(
      ClassificationModule module) {
    return new ClassificationModule_ProvideClassificationContentAdapterFactory(module);
  }

  public static ClassificationContentAdapter proxyProvideClassificationContentAdapter(
      ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideClassificationContentAdapter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
