package com.wy.adbook.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GenderModel_Factory implements Factory<GenderModel> {
  private final Provider<IRepositoryManager> rmProvider;

  public GenderModel_Factory(Provider<IRepositoryManager> rmProvider) {
    this.rmProvider = rmProvider;
  }

  @Override
  public GenderModel get() {
    return new GenderModel(rmProvider.get());
  }

  public static GenderModel_Factory create(Provider<IRepositoryManager> rmProvider) {
    return new GenderModel_Factory(rmProvider);
  }
}
