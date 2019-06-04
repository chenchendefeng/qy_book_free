package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ClassificationDetailContract;
import com.wy.adbook.mvp.model.ClassificationDetailModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationDetailModule_ProvideAboutModelFactory
    implements Factory<ClassificationDetailContract.Model> {
  private final ClassificationDetailModule module;

  private final Provider<ClassificationDetailModel> modelProvider;

  public ClassificationDetailModule_ProvideAboutModelFactory(
      ClassificationDetailModule module, Provider<ClassificationDetailModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public ClassificationDetailContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationDetailModule_ProvideAboutModelFactory create(
      ClassificationDetailModule module, Provider<ClassificationDetailModel> modelProvider) {
    return new ClassificationDetailModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static ClassificationDetailContract.Model proxyProvideAboutModel(
      ClassificationDetailModule instance, ClassificationDetailModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
