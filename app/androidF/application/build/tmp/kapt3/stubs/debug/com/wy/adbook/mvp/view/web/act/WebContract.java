package com.wy.adbook.mvp.view.web.act;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-23.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/mvp/view/web/act/WebContract;", "", "Model", "View", "application_debug"})
public abstract interface WebContract {
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/wy/adbook/mvp/view/web/act/WebContract$View;", "Lcom/wy/adbook/app/base/QYView;", "application_debug"})
    public static abstract interface View extends com.wy.adbook.app.base.QYView {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/wy/adbook/mvp/view/web/act/WebContract$Model;", "Lcom/wy/adbook/app/base/QYModel;", "application_debug"})
    public static abstract interface Model extends com.wy.adbook.app.base.QYModel {
    }
}