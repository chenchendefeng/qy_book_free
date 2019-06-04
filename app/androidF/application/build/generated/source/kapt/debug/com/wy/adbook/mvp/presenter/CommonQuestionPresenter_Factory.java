package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.CommonQuestionContract;
import com.wy.adbook.mvp.model.entity.FaqItem;
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionPresenter_Factory implements Factory<CommonQuestionPresenter> {
  private final Provider<CommonQuestionContract.Model> modelProvider;

  private final Provider<CommonQuestionContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<CommonQuestionAdapter> commonQuestionAdapterProvider;

  private final Provider<List<FaqItem>> faqListProvider;

  public CommonQuestionPresenter_Factory(
      Provider<CommonQuestionContract.Model> modelProvider,
      Provider<CommonQuestionContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<CommonQuestionAdapter> commonQuestionAdapterProvider,
      Provider<List<FaqItem>> faqListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.commonQuestionAdapterProvider = commonQuestionAdapterProvider;
    this.faqListProvider = faqListProvider;
  }

  @Override
  public CommonQuestionPresenter get() {
    CommonQuestionPresenter instance =
        new CommonQuestionPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    CommonQuestionPresenter_MembersInjector.injectCommonQuestionAdapter(
        instance, commonQuestionAdapterProvider.get());
    CommonQuestionPresenter_MembersInjector.injectFaqList(instance, faqListProvider.get());
    return instance;
  }

  public static CommonQuestionPresenter_Factory create(
      Provider<CommonQuestionContract.Model> modelProvider,
      Provider<CommonQuestionContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<CommonQuestionAdapter> commonQuestionAdapterProvider,
      Provider<List<FaqItem>> faqListProvider) {
    return new CommonQuestionPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        commonQuestionAdapterProvider,
        faqListProvider);
  }

  public static CommonQuestionPresenter newCommonQuestionPresenter(
      CommonQuestionContract.Model model, CommonQuestionContract.View view) {
    return new CommonQuestionPresenter(model, view);
  }
}
