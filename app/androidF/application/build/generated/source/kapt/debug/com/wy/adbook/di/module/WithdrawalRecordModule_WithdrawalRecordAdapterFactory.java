package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem;
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordModule_WithdrawalRecordAdapterFactory
    implements Factory<WithdrawalRecordAdapter> {
  private final WithdrawalRecordModule module;

  private final Provider<List<WithdrawalRecordItem>> listProvider;

  public WithdrawalRecordModule_WithdrawalRecordAdapterFactory(
      WithdrawalRecordModule module, Provider<List<WithdrawalRecordItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public WithdrawalRecordAdapter get() {
    return Preconditions.checkNotNull(
        module.withdrawalRecordAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalRecordModule_WithdrawalRecordAdapterFactory create(
      WithdrawalRecordModule module, Provider<List<WithdrawalRecordItem>> listProvider) {
    return new WithdrawalRecordModule_WithdrawalRecordAdapterFactory(module, listProvider);
  }

  public static WithdrawalRecordAdapter proxyWithdrawalRecordAdapter(
      WithdrawalRecordModule instance, List<WithdrawalRecordItem> list) {
    return Preconditions.checkNotNull(
        instance.withdrawalRecordAdapter(list),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
