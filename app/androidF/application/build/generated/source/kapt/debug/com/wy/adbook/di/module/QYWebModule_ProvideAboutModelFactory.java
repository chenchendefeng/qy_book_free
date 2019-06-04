package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.web.frag.QYWebContract;
import com.wy.adbook.mvp.view.web.frag.QYWebModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebModule_ProvideAboutModelFactory implements Factory<QYWebContract.Model> {
  private final QYWebModule module;

  private final Provider<QYWebModel> modelProvider;

  public QYWebModule_ProvideAboutModelFactory(
      QYWebModule module, Provider<QYWebModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public QYWebContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static QYWebModule_ProvideAboutModelFactory create(
      QYWebModule module, Provider<QYWebModel> modelProvider) {
    return new QYWebModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static QYWebContract.Model proxyProvideAboutModel(QYWebModule instance, QYWebModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
