package com.wy.adbook.mvp.view.web.frag;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.view.web.QYWebView;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebFragment_MembersInjector implements MembersInjector<QYWebFragment> {
  private final Provider<QYWebPresenter> mPresenterProvider;

  private final Provider<QYWebView> webViewProvider;

  public QYWebFragment_MembersInjector(
      Provider<QYWebPresenter> mPresenterProvider, Provider<QYWebView> webViewProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.webViewProvider = webViewProvider;
  }

  public static MembersInjector<QYWebFragment> create(
      Provider<QYWebPresenter> mPresenterProvider, Provider<QYWebView> webViewProvider) {
    return new QYWebFragment_MembersInjector(mPresenterProvider, webViewProvider);
  }

  @Override
  public void injectMembers(QYWebFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectWebView(instance, webViewProvider.get());
  }

  public static void injectWebView(QYWebFragment instance, QYWebView webView) {
    instance.webView = webView;
  }
}
