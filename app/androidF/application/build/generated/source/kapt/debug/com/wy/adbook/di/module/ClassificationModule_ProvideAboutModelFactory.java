package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ClassificationContract;
import com.wy.adbook.mvp.model.ClassificationModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideAboutModelFactory
    implements Factory<ClassificationContract.Model> {
  private final ClassificationModule module;

  private final Provider<ClassificationModel> modelProvider;

  public ClassificationModule_ProvideAboutModelFactory(
      ClassificationModule module, Provider<ClassificationModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public ClassificationContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideAboutModelFactory create(
      ClassificationModule module, Provider<ClassificationModel> modelProvider) {
    return new ClassificationModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static ClassificationContract.Model proxyProvideAboutModel(
      ClassificationModule instance, ClassificationModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
