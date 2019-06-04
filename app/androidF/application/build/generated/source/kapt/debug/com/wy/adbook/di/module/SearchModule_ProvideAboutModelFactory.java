package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.SearchContract;
import com.wy.adbook.mvp.model.SearchModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchModule_ProvideAboutModelFactory implements Factory<SearchContract.Model> {
  private final SearchModule module;

  private final Provider<SearchModel> modelProvider;

  public SearchModule_ProvideAboutModelFactory(
      SearchModule module, Provider<SearchModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public SearchContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SearchModule_ProvideAboutModelFactory create(
      SearchModule module, Provider<SearchModel> modelProvider) {
    return new SearchModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static SearchContract.Model proxyProvideAboutModel(
      SearchModule instance, SearchModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
