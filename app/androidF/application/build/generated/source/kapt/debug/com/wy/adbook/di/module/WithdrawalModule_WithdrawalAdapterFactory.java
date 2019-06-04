package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.WithdrawalItem;
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalModule_WithdrawalAdapterFactory
    implements Factory<WithdrawablAdapter> {
  private final WithdrawalModule module;

  private final Provider<List<WithdrawalItem>> list1Provider;

  public WithdrawalModule_WithdrawalAdapterFactory(
      WithdrawalModule module, Provider<List<WithdrawalItem>> list1Provider) {
    this.module = module;
    this.list1Provider = list1Provider;
  }

  @Override
  public WithdrawablAdapter get() {
    return Preconditions.checkNotNull(
        module.withdrawalAdapter(list1Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalModule_WithdrawalAdapterFactory create(
      WithdrawalModule module, Provider<List<WithdrawalItem>> list1Provider) {
    return new WithdrawalModule_WithdrawalAdapterFactory(module, list1Provider);
  }

  public static WithdrawablAdapter proxyWithdrawalAdapter(
      WithdrawalModule instance, List<WithdrawalItem> list1) {
    return Preconditions.checkNotNull(
        instance.withdrawalAdapter(list1),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
