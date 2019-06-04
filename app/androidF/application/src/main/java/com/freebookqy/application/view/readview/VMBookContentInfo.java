//package com.freebookqy.application.view.readview;
//
//import com.freebookqy.application.app.base.QYModel;
//import com.freebookqy.application.mvp.model.entity.ChapterReadUrlBean;
//import com.freebookqy.application.view.readview.bean.TxtChapter;
//import com.freebookqy.application.view.readview.manager.BookManager;
//import com.freebookqy.utilslib.ThreadManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Liang_Lu on 2017/12/11.
// */
//
//public class VMBookContentInfo implements QYModel {
//    IBookChapters iBookChapters;
//
//    List<rx.Subscription> mSubscriptions = new ArrayList<>();
//
//    XActivity mContext;
//
//    public VMBookContentInfo(XActivity context, IBookChapters iBookChapters) {
//        super(context);
//        mContext = context;
//        this.iBookChapters = iBookChapters;
//    }
//
//    public void loadChapters(String cbid) {
////        QianYueApi.getApiService().getBookChapters(cbid)
////                .compose(XApi.<BookMixAToc>getApiTransformer())
////                .compose(XApi.<BookMixAToc>getScheduler())
////                .subscribe(new ApiSubcriber<BookMixAToc>() {
////                    @Override
////                    protected void onFail(NetError error) {
////                        mContext.closeLoadingDialog();
////                    }
////
////                    @Override
////                    public void onNext(final BookMixAToc bookMixAToc) {
////                        mContext.closeLoadingDialog();
////                        if (ConfigUtils.SUCCESS.equals(bookMixAToc.getResult())) {
////                            if (iBookChapters != null) {
////                                iBookChapters.bookChapters(bookMixAToc);
////                            }
////                        }
////                    }
////                });
//
//    }
//
//
//    rx.Subscription tmpSubscription;
//
//
//    //加载当前内容
//    private void loadCurrentContent(String bookId, final List<TxtChapter> bookChapterList) {
//        TxtChapter bookChapter = bookChapterList.get(0);
//        if (!(BookManager.getInstance().isChapterCached(bookId, bookChapter.CCID))) {
//            tmpSubscription =
//                    QianYueApi.getApiService().getChapterRead(bookId, bookChapter.CCID, "1")
//                            .compose(XApi.<ChapterReadUrlBean>getApiTransformer())
//                            .compose(XApi.<ChapterReadUrlBean>getScheduler())
//                            .subscribe(new ApiSubcriber<ChapterReadUrlBean>() {
//                                @Override
//                                protected void onFail(NetError error) {
//                                    if (tmpSubscription != null) {
//                                        mSubscriptions.remove(tmpSubscription);
//                                    }
//                                }
//
//                                @Override
//                                public void onNext(ChapterReadUrlBean bean) {
//                                    if (tmpSubscription != null) {
//                                        mSubscriptions.remove(tmpSubscription);
//                                    }
//                                    if (ConfigUtils.SUCCESS.equals(bean.getResult())) {
//                                        getOssStr(bookId, bean.data.ccid, bean.data.content, true);
//                                        loadCacheContent(bookId, bookChapterList);
//                                    } else {
//                                        iBookChapters.errorChapters();
//                                        //LogUtils.e(bean.getErrorMsg());
//                                    }
//                                }
//                            });
//
//            mSubscriptions.add(tmpSubscription);
//        } else {
//            if (iBookChapters != null) {
//                iBookChapters.finishChapters();
//            }
//            loadCacheContent(bookId, bookChapterList);
//        }
//
//    }
//
//    private void loadCacheContent(String bookId, final List<TxtChapter> bookChapterList) {
//        int size = bookChapterList.size();
//
//        //首先判断是否Chapter已经存在
//        for (int i = 1; i < size; i++) {
//            TxtChapter bookChapter = bookChapterList.get(i);
//            if (!(BookManager.getInstance().isChapterCached(bookId, bookChapter.CCID))) {
//                tmpSubscription = QianYueApi.getApiService().getChapterRead(bookId, bookChapter.CCID, "1")
//                        .compose(XApi.<ChapterReadUrlBean>getApiTransformer())
//                        .compose(XApi.<ChapterReadUrlBean>getScheduler())
//                        .subscribe(new ApiSubcriber<ChapterReadUrlBean>() {
//                            @Override
//                            protected void onFail(NetError error) {
//
//                                if (tmpSubscription != null) {
//                                    mSubscriptions.remove(tmpSubscription);
//                                }
//                            }
//
//                            @Override
//                            public void onNext(ChapterReadUrlBean bean) {
//                                if (tmpSubscription != null) {
//                                    mSubscriptions.remove(tmpSubscription);
//                                }
//                                if (ConfigUtils.SUCCESS.equals(bean.getResult())) {
//                                    getOssStr(bookId, bean.data.ccid, bean.data.content, false);
//                                } else {
//                                    LogUtils.e(bean.getErrorMsg());
//                                }
//                            }
//
//
//                        });
//
//                mSubscriptions.add(tmpSubscription);
//            }
//        }
//    }
//
//    /**
//     * 加载正文
//     *
//     * @param bookId
//     * @param bookChapterList
//     */
//    public void loadContent(final String bookId, final List<TxtChapter> bookChapterList) {
//        //取消上次的任务，防止多次加载
//        if (mSubscriptions != null) {
//            int k = mSubscriptions.size();
//            for (int i = k - 1; i >= 0; i--) {
//                mSubscriptions.remove(i).unsubscribe();
//            }
//        }
//        int size = bookChapterList.size();
//        if (size <= 0) {
//            return;
//        }
//
//        loadCurrentContent(bookId, bookChapterList);
//
//
//    }
//
////    public void getOssStr(final String bookId, final String ccid, String url, boolean isCurrent) {
////
////        //1.创建OkHttpClient对象
////        OkHttpClient okHttpClient = new OkHttpClient();
////
////        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
////        Request request = new Request.Builder().url(url).method("GET", null).build();
////        //3.创建一个call对象,参数就是Request请求对象
////        Call call = okHttpClient.newCall(request);
////        //4.请求加入调度，重写回调方法
////        call.enqueue(new Callback() {
////            //请求失败执行的方法
////            @Override
////            public void onFailure(Call call, IOException e) {
////            }
////
////            //请求成功执行的方法
////            @Override
////            public void onResponse(Call call, final Response response) throws IOException {
////                InputStream is = response.body().byteStream();
////                BookManager.getInstance().saveChapterInfo(bookId, ccid, inputStream2String(is));
////                if (isCurrent) {
////                    ThreadManager.getMainHandler().post(new Runnable() {
////                        @Override
////                        public void run() {
////                            iBookChapters.finishChapters();
////
////                        }
////                    });
////                }
////            }
////        });
////    }
//
////    public String inputStream2String(InputStream in) throws IOException {
////        StringBuffer out = new StringBuffer();
////        byte[] b = new byte[4096];
////        for (int n; (n = in.read(b)) != -1; ) {
////            out.append(new String(b, 0, n));
////        }
////        return out.toString();
////    }
//
//    public void getOssStr(final String bookId, final String ccid, String content, boolean isCurrent) {
//
//        BookManager.getInstance().saveChapterInfo(bookId, ccid, content);
//        if (isCurrent) {
//            ThreadManager.getMainHandler().post(new Runnable() {
//                @Override
//                public void run() {
//                    iBookChapters.finishChapters();
//
//                }
//            });
//        }
//
//    }
//
//
//}
