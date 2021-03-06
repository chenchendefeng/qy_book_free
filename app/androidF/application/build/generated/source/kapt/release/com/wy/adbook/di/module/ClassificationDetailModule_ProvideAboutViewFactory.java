package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ClassificationDetailContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationDetailModule_ProvideAboutViewFactory
    implements Factory<ClassificationDetailContract.View> {
  private final ClassificationDetailModule module;

  public ClassificationDetailModule_ProvideAboutViewFactory(ClassificationDetailModule module) {
    this.module = module;
  }

  @Override
  public ClassificationDetailContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationDetailModule_ProvideAboutViewFactory create(
      ClassificationDetailModule module) {
    return new ClassificationDetailModule_ProvideAboutViewFactory(module);
  }

  public static ClassificationDetailContract.View proxyProvideAboutView(
      ClassificationDetailModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
