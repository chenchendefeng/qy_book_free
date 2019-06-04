package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.FaqItem;
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionPresenter_MembersInjector
    implements MembersInjector<CommonQuestionPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<CommonQuestionAdapter> commonQuestionAdapterProvider;

  private final Provider<List<FaqItem>> faqListProvider;

  public CommonQuestionPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<CommonQuestionAdapter> commonQuestionAdapterProvider,
      Provider<List<FaqItem>> faqListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.commonQuestionAdapterProvider = commonQuestionAdapterProvider;
    this.faqListProvider = faqListProvider;
  }

  public static MembersInjector<CommonQuestionPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<CommonQuestionAdapter> commonQuestionAdapterProvider,
      Provider<List<FaqItem>> faqListProvider) {
    return new CommonQuestionPresenter_MembersInjector(
        mErrorHandlerProvider, commonQuestionAdapterProvider, faqListProvider);
  }

  @Override
  public void injectMembers(CommonQuestionPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectCommonQuestionAdapter(instance, commonQuestionAdapterProvider.get());
    injectFaqList(instance, faqListProvider.get());
  }

  public static void injectCommonQuestionAdapter(
      CommonQuestionPresenter instance, CommonQuestionAdapter commonQuestionAdapter) {
    instance.commonQuestionAdapter = commonQuestionAdapter;
  }

  public static void injectFaqList(CommonQuestionPresenter instance, List<FaqItem> faqList) {
    instance.faqList = faqList;
  }
}
