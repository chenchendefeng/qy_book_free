package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.FaqItem;
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionModule_ProvideCommonQuestionAdapterFactory
    implements Factory<CommonQuestionAdapter> {
  private final CommonQuestionModule module;

  private final Provider<List<FaqItem>> listProvider;

  public CommonQuestionModule_ProvideCommonQuestionAdapterFactory(
      CommonQuestionModule module, Provider<List<FaqItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public CommonQuestionAdapter get() {
    return Preconditions.checkNotNull(
        module.provideCommonQuestionAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static CommonQuestionModule_ProvideCommonQuestionAdapterFactory create(
      CommonQuestionModule module, Provider<List<FaqItem>> listProvider) {
    return new CommonQuestionModule_ProvideCommonQuestionAdapterFactory(module, listProvider);
  }

  public static CommonQuestionAdapter proxyProvideCommonQuestionAdapter(
      CommonQuestionModule instance, List<FaqItem> list) {
    return Preconditions.checkNotNull(
        instance.provideCommonQuestionAdapter(list),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
