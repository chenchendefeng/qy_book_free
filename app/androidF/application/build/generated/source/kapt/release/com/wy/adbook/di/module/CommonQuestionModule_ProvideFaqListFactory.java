package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.FaqItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionModule_ProvideFaqListFactory implements Factory<List<FaqItem>> {
  private final CommonQuestionModule module;

  public CommonQuestionModule_ProvideFaqListFactory(CommonQuestionModule module) {
    this.module = module;
  }

  @Override
  public List<FaqItem> get() {
    return Preconditions.checkNotNull(
        module.provideFaqList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static CommonQuestionModule_ProvideFaqListFactory create(CommonQuestionModule module) {
    return new CommonQuestionModule_ProvideFaqListFactory(module);
  }

  public static List<FaqItem> proxyProvideFaqList(CommonQuestionModule instance) {
    return Preconditions.checkNotNull(
        instance.provideFaqList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
