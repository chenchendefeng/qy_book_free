package com.wy.adbook.mvp.model.event;

import com.wy.adbook.mvp.model.dao.CollBookBean;

/**
 * Created by newbiechen on 17-5-27.
 */

public class DeleteTaskEvent {
    public CollBookBean collBook;

    public DeleteTaskEvent(CollBookBean collBook){
        this.collBook = collBook;
    }
}
