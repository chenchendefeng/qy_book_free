package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ClassificationContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideAboutViewFactory
    implements Factory<ClassificationContract.View> {
  private final ClassificationModule module;

  public ClassificationModule_ProvideAboutViewFactory(ClassificationModule module) {
    this.module = module;
  }

  @Override
  public ClassificationContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideAboutViewFactory create(ClassificationModule module) {
    return new ClassificationModule_ProvideAboutViewFactory(module);
  }

  public static ClassificationContract.View proxyProvideAboutView(ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
