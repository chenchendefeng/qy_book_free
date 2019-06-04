package com.freebookqy.application.mvp.model.entity;

import com.freebookqy.application.app.base.BaseEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 获取章节oss url
 */
public class ChapterReadUrlBean extends BaseEntity {

    public ChapterReadUrlListBean data;

    public ChapterReadUrlBean(
            @NotNull String result,
            @NotNull String msg,
            @Nullable Object data,
            @Nullable Object otherData) {
        super(result, msg, data, otherData);
    }
}
