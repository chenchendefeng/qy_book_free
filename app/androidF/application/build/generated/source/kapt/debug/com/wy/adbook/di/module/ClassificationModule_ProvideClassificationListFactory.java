package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.Classification;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideClassificationListFactory
    implements Factory<List<Classification>> {
  private final ClassificationModule module;

  public ClassificationModule_ProvideClassificationListFactory(ClassificationModule module) {
    this.module = module;
  }

  @Override
  public List<Classification> get() {
    return Preconditions.checkNotNull(
        module.provideClassificationList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideClassificationListFactory create(
      ClassificationModule module) {
    return new ClassificationModule_ProvideClassificationListFactory(module);
  }

  public static List<Classification> proxyProvideClassificationList(ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideClassificationList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
