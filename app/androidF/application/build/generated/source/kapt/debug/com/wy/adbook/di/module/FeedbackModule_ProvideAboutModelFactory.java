package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.FeedbackContract;
import com.wy.adbook.mvp.model.FeedbackModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedbackModule_ProvideAboutModelFactory
    implements Factory<FeedbackContract.Model> {
  private final FeedbackModule module;

  private final Provider<FeedbackModel> modelProvider;

  public FeedbackModule_ProvideAboutModelFactory(
      FeedbackModule module, Provider<FeedbackModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public FeedbackContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static FeedbackModule_ProvideAboutModelFactory create(
      FeedbackModule module, Provider<FeedbackModel> modelProvider) {
    return new FeedbackModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static FeedbackContract.Model proxyProvideAboutModel(
      FeedbackModule instance, FeedbackModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
