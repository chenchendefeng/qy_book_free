package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.WithdrawalItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalModule_CashWithdrawalItemListFactory
    implements Factory<List<WithdrawalItem>> {
  private final WithdrawalModule module;

  public WithdrawalModule_CashWithdrawalItemListFactory(WithdrawalModule module) {
    this.module = module;
  }

  @Override
  public List<WithdrawalItem> get() {
    return Preconditions.checkNotNull(
        module.cashWithdrawalItemList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalModule_CashWithdrawalItemListFactory create(WithdrawalModule module) {
    return new WithdrawalModule_CashWithdrawalItemListFactory(module);
  }

  public static List<WithdrawalItem> proxyCashWithdrawalItemList(WithdrawalModule instance) {
    return Preconditions.checkNotNull(
        instance.cashWithdrawalItemList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
