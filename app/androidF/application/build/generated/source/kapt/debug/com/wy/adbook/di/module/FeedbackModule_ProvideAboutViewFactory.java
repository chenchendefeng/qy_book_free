package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.FeedbackContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedbackModule_ProvideAboutViewFactory
    implements Factory<FeedbackContract.View> {
  private final FeedbackModule module;

  public FeedbackModule_ProvideAboutViewFactory(FeedbackModule module) {
    this.module = module;
  }

  @Override
  public FeedbackContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static FeedbackModule_ProvideAboutViewFactory create(FeedbackModule module) {
    return new FeedbackModule_ProvideAboutViewFactory(module);
  }

  public static FeedbackContract.View proxyProvideAboutView(FeedbackModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
