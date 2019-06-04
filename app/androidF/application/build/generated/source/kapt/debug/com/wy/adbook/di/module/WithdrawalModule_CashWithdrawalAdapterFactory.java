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
public final class WithdrawalModule_CashWithdrawalAdapterFactory
    implements Factory<WithdrawablAdapter> {
  private final WithdrawalModule module;

  private final Provider<List<WithdrawalItem>> list2Provider;

  public WithdrawalModule_CashWithdrawalAdapterFactory(
      WithdrawalModule module, Provider<List<WithdrawalItem>> list2Provider) {
    this.module = module;
    this.list2Provider = list2Provider;
  }

  @Override
  public WithdrawablAdapter get() {
    return Preconditions.checkNotNull(
        module.cashWithdrawalAdapter(list2Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalModule_CashWithdrawalAdapterFactory create(
      WithdrawalModule module, Provider<List<WithdrawalItem>> list2Provider) {
    return new WithdrawalModule_CashWithdrawalAdapterFactory(module, list2Provider);
  }

  public static WithdrawablAdapter proxyCashWithdrawalAdapter(
      WithdrawalModule instance, List<WithdrawalItem> list2) {
    return Preconditions.checkNotNull(
        instance.cashWithdrawalAdapter(list2),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
