package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.accout.RewardItem;
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ContinuousSignInAdapterFactory
    implements Factory<ContinuousSignInAdapter> {
  private final SignCalenderModule module;

  private final Provider<List<RewardItem>> dataListProvider;

  public SignCalenderModule_ContinuousSignInAdapterFactory(
      SignCalenderModule module, Provider<List<RewardItem>> dataListProvider) {
    this.module = module;
    this.dataListProvider = dataListProvider;
  }

  @Override
  public ContinuousSignInAdapter get() {
    return Preconditions.checkNotNull(
        module.continuousSignInAdapter(dataListProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ContinuousSignInAdapterFactory create(
      SignCalenderModule module, Provider<List<RewardItem>> dataListProvider) {
    return new SignCalenderModule_ContinuousSignInAdapterFactory(module, dataListProvider);
  }

  public static ContinuousSignInAdapter proxyContinuousSignInAdapter(
      SignCalenderModule instance, List<RewardItem> dataList) {
    return Preconditions.checkNotNull(
        instance.continuousSignInAdapter(dataList),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
