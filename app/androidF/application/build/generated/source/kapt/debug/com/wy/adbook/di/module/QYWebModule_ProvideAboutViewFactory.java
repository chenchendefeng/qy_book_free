package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.web.frag.QYWebContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebModule_ProvideAboutViewFactory implements Factory<QYWebContract.View> {
  private final QYWebModule module;

  public QYWebModule_ProvideAboutViewFactory(QYWebModule module) {
    this.module = module;
  }

  @Override
  public QYWebContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static QYWebModule_ProvideAboutViewFactory create(QYWebModule module) {
    return new QYWebModule_ProvideAboutViewFactory(module);
  }

  public static QYWebContract.View proxyProvideAboutView(QYWebModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
