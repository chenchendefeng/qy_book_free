package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.CommonQuestionContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionModule_ProvideAboutViewFactory
    implements Factory<CommonQuestionContract.View> {
  private final CommonQuestionModule module;

  public CommonQuestionModule_ProvideAboutViewFactory(CommonQuestionModule module) {
    this.module = module;
  }

  @Override
  public CommonQuestionContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static CommonQuestionModule_ProvideAboutViewFactory create(CommonQuestionModule module) {
    return new CommonQuestionModule_ProvideAboutViewFactory(module);
  }

  public static CommonQuestionContract.View proxyProvideAboutView(CommonQuestionModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
