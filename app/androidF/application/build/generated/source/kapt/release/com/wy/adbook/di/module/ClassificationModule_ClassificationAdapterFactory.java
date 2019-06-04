package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.Classification;
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ClassificationAdapterFactory
    implements Factory<ClassificationAdapter> {
  private final ClassificationModule module;

  private final Provider<List<Classification>> listProvider;

  public ClassificationModule_ClassificationAdapterFactory(
      ClassificationModule module, Provider<List<Classification>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public ClassificationAdapter get() {
    return Preconditions.checkNotNull(
        module.classificationAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ClassificationAdapterFactory create(
      ClassificationModule module, Provider<List<Classification>> listProvider) {
    return new ClassificationModule_ClassificationAdapterFactory(module, listProvider);
  }

  public static ClassificationAdapter proxyClassificationAdapter(
      ClassificationModule instance, List<Classification> list) {
    return Preconditions.checkNotNull(
        instance.classificationAdapter(list),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
