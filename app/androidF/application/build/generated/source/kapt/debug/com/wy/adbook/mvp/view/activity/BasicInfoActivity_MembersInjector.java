package com.wy.adbook.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.BasicInfoPresenter;
import com.wy.adbook.mvp.view.adapter.BasicInfoAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoActivity_MembersInjector implements MembersInjector<BasicInfoActivity> {
  private final Provider<BasicInfoPresenter> mPresenterProvider;

  private final Provider<BasicInfoAdapter> basicInfoAdapterProvider;

  private final Provider<LinearLayoutManager> llmProvider;

  public BasicInfoActivity_MembersInjector(
      Provider<BasicInfoPresenter> mPresenterProvider,
      Provider<BasicInfoAdapter> basicInfoAdapterProvider,
      Provider<LinearLayoutManager> llmProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.basicInfoAdapterProvider = basicInfoAdapterProvider;
    this.llmProvider = llmProvider;
  }

  public static MembersInjector<BasicInfoActivity> create(
      Provider<BasicInfoPresenter> mPresenterProvider,
      Provider<BasicInfoAdapter> basicInfoAdapterProvider,
      Provider<LinearLayoutManager> llmProvider) {
    return new BasicInfoActivity_MembersInjector(
        mPresenterProvider, basicInfoAdapterProvider, llmProvider);
  }

  @Override
  public void injectMembers(BasicInfoActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectBasicInfoAdapter(instance, basicInfoAdapterProvider.get());
    injectLlm(instance, llmProvider.get());
  }

  public static void injectBasicInfoAdapter(
      BasicInfoActivity instance, BasicInfoAdapter basicInfoAdapter) {
    instance.basicInfoAdapter = basicInfoAdapter;
  }

  public static void injectLlm(BasicInfoActivity instance, LinearLayoutManager llm) {
    instance.llm = llm;
  }
}
