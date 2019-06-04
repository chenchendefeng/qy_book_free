package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.CommonQuestionContract;
import com.wy.adbook.mvp.model.CommonQuestionModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionModule_ProvideAboutModelFactory
    implements Factory<CommonQuestionContract.Model> {
  private final CommonQuestionModule module;

  private final Provider<CommonQuestionModel> modelProvider;

  public CommonQuestionModule_ProvideAboutModelFactory(
      CommonQuestionModule module, Provider<CommonQuestionModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public CommonQuestionContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static CommonQuestionModule_ProvideAboutModelFactory create(
      CommonQuestionModule module, Provider<CommonQuestionModel> modelProvider) {
    return new CommonQuestionModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static CommonQuestionContract.Model proxyProvideAboutModel(
      CommonQuestionModule instance, CommonQuestionModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
