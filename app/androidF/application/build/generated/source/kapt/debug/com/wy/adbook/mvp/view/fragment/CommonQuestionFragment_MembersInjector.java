package com.wy.adbook.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.model.entity.FaqItem;
import com.wy.adbook.mvp.presenter.CommonQuestionPresenter;
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionFragment_MembersInjector
    implements MembersInjector<CommonQuestionFragment> {
  private final Provider<CommonQuestionPresenter> mPresenterProvider;

  private final Provider<CommonQuestionAdapter> commonQuestionAdapterProvider;

  private final Provider<LinearLayoutManager> linearLayoutManagerProvider;

  private final Provider<List<FaqItem>> faqListProvider;

  public CommonQuestionFragment_MembersInjector(
      Provider<CommonQuestionPresenter> mPresenterProvider,
      Provider<CommonQuestionAdapter> commonQuestionAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider,
      Provider<List<FaqItem>> faqListProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.commonQuestionAdapterProvider = commonQuestionAdapterProvider;
    this.linearLayoutManagerProvider = linearLayoutManagerProvider;
    this.faqListProvider = faqListProvider;
  }

  public static MembersInjector<CommonQuestionFragment> create(
      Provider<CommonQuestionPresenter> mPresenterProvider,
      Provider<CommonQuestionAdapter> commonQuestionAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider,
      Provider<List<FaqItem>> faqListProvider) {
    return new CommonQuestionFragment_MembersInjector(
        mPresenterProvider,
        commonQuestionAdapterProvider,
        linearLayoutManagerProvider,
        faqListProvider);
  }

  @Override
  public void injectMembers(CommonQuestionFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectCommonQuestionAdapter(instance, commonQuestionAdapterProvider.get());
    injectLinearLayoutManager(instance, linearLayoutManagerProvider.get());
    injectFaqList(instance, faqListProvider.get());
  }

  public static void injectCommonQuestionAdapter(
      CommonQuestionFragment instance, CommonQuestionAdapter commonQuestionAdapter) {
    instance.commonQuestionAdapter = commonQuestionAdapter;
  }

  public static void injectLinearLayoutManager(
      CommonQuestionFragment instance, LinearLayoutManager linearLayoutManager) {
    instance.linearLayoutManager = linearLayoutManager;
  }

  public static void injectFaqList(CommonQuestionFragment instance, List<FaqItem> faqList) {
    instance.faqList = faqList;
  }
}
