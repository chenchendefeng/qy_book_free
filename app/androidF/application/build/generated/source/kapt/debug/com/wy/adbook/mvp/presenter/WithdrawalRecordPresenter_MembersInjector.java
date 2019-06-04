package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem;
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordPresenter_MembersInjector
    implements MembersInjector<WithdrawalRecordPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider;

  private final Provider<List<WithdrawalRecordItem>> recordItemListProvider;

  public WithdrawalRecordPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider,
      Provider<List<WithdrawalRecordItem>> recordItemListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.withdrawalRecordAdapterProvider = withdrawalRecordAdapterProvider;
    this.recordItemListProvider = recordItemListProvider;
  }

  public static MembersInjector<WithdrawalRecordPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider,
      Provider<List<WithdrawalRecordItem>> recordItemListProvider) {
    return new WithdrawalRecordPresenter_MembersInjector(
        mErrorHandlerProvider, withdrawalRecordAdapterProvider, recordItemListProvider);
  }

  @Override
  public void injectMembers(WithdrawalRecordPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectWithdrawalRecordAdapter(instance, withdrawalRecordAdapterProvider.get());
    injectRecordItemList(instance, recordItemListProvider.get());
  }

  public static void injectWithdrawalRecordAdapter(
      WithdrawalRecordPresenter instance, WithdrawalRecordAdapter withdrawalRecordAdapter) {
    instance.withdrawalRecordAdapter = withdrawalRecordAdapter;
  }

  public static void injectRecordItemList(
      WithdrawalRecordPresenter instance, List<WithdrawalRecordItem> recordItemList) {
    instance.recordItemList = recordItemList;
  }
}
