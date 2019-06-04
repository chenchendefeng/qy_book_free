package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.HelpCenterPresenter;
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment;
import com.wy.adbook.mvp.view.fragment.FeedbackFragment;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterActivity_MembersInjector
    implements MembersInjector<HelpCenterActivity> {
  private final Provider<HelpCenterPresenter> mPresenterProvider;

  private final Provider<List<String>> indicatorListProvider;

  private final Provider<CommonQuestionFragment> commonQuestionFragmentProvider;

  private final Provider<FeedbackFragment> feedbackFragmentProvider;

  public HelpCenterActivity_MembersInjector(
      Provider<HelpCenterPresenter> mPresenterProvider,
      Provider<List<String>> indicatorListProvider,
      Provider<CommonQuestionFragment> commonQuestionFragmentProvider,
      Provider<FeedbackFragment> feedbackFragmentProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.indicatorListProvider = indicatorListProvider;
    this.commonQuestionFragmentProvider = commonQuestionFragmentProvider;
    this.feedbackFragmentProvider = feedbackFragmentProvider;
  }

  public static MembersInjector<HelpCenterActivity> create(
      Provider<HelpCenterPresenter> mPresenterProvider,
      Provider<List<String>> indicatorListProvider,
      Provider<CommonQuestionFragment> commonQuestionFragmentProvider,
      Provider<FeedbackFragment> feedbackFragmentProvider) {
    return new HelpCenterActivity_MembersInjector(
        mPresenterProvider,
        indicatorListProvider,
        commonQuestionFragmentProvider,
        feedbackFragmentProvider);
  }

  @Override
  public void injectMembers(HelpCenterActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectIndicatorList(instance, indicatorListProvider.get());
    injectCommonQuestionFragment(instance, commonQuestionFragmentProvider.get());
    injectFeedbackFragment(instance, feedbackFragmentProvider.get());
  }

  public static void injectIndicatorList(HelpCenterActivity instance, List<String> indicatorList) {
    instance.indicatorList = indicatorList;
  }

  public static void injectCommonQuestionFragment(
      HelpCenterActivity instance, CommonQuestionFragment commonQuestionFragment) {
    instance.commonQuestionFragment = commonQuestionFragment;
  }

  public static void injectFeedbackFragment(
      HelpCenterActivity instance, FeedbackFragment feedbackFragment) {
    instance.feedbackFragment = feedbackFragment;
  }
}
