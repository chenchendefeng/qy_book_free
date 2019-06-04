package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordModule_WithdrawalRecordItemListFactory
    implements Factory<List<WithdrawalRecordItem>> {
  private final WithdrawalRecordModule module;

  public WithdrawalRecordModule_WithdrawalRecordItemListFactory(WithdrawalRecordModule module) {
    this.module = module;
  }

  @Override
  public List<WithdrawalRecordItem> get() {
    return Preconditions.checkNotNull(
        module.withdrawalRecordItemList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalRecordModule_WithdrawalRecordItemListFactory create(
      WithdrawalRecordModule module) {
    return new WithdrawalRecordModule_WithdrawalRecordItemListFactory(module);
  }

  public static List<WithdrawalRecordItem> proxyWithdrawalRecordItemList(
      WithdrawalRecordModule instance) {
    return Preconditions.checkNotNull(
        instance.withdrawalRecordItemList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
