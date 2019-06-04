//package com.freebookqy.application.view.readview.read;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.freebookqy.application.R;
//import com.freebookqy.application.mvp.model.entity.book.bookread.BookDetailsBean;
//import com.freebookqy.application.view.readview.bean.WappageData;
//import com.freebookqy.application.view.readview.utils.TypeFaceUtils;
//import com.google.gson.Gson;
//
//public class ReadWappageView {
//    Context mContext;
//    ViewGroup parentView;
//    View contentView;
//    BookDetailsBean bookBean;
//    WappageData.DataBean data;
//
//    public ReadWappageView(BookDetailsBean bean) {
//
//        this.bookBean = bean;
//        data = new Gson().fromJson(bean.getWappageData(), WappageData.DataBean.class);
//
//    }
//
//    ImageView wappage_book_img;
//    TextView wappage_book_name;
//    TextView wappage_book_auth;
//    TextView wappage_book_content;
//    private int lastX, lastY;
//
//    public void create(ViewGroup parentView) {
//        this.parentView = parentView;
//        mContext = parentView.getContext();
//        contentView = LayoutInflater.from(mContext).inflate(R.layout.read_page_wrappage, null);
//
//        wappage_book_img = contentView.findViewById(R.id.wappage_book_img);
//        wappage_book_name = contentView.findViewById(R.id.wappage_book_name);
//        TypeFaceUtils.bindTypeFace_SourceHanSerifCN_Regular(wappage_book_name);
//        wappage_book_auth = contentView.findViewById(R.id.wappage_book_auth);
//        TypeFaceUtils.bindTypeFace_SourceHanSerifCN_Regular(wappage_book_auth);
//        wappage_book_content = contentView.findViewById(R.id.wappage_book_content);
//
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//        parentView.addView(contentView, params);
//
//        contentView.setOnClickListener(v -> close());
//        if (data == null || TextUtils.isEmpty(data.cbid)) {
//            getWappage(bookBean.getCBID());
//        } else {
//            initData(data);
//        }
//
//    }
//
//    public void initData(WappageData.DataBean data) {
//        //ImageLoader.getInstance().displayImage(mContext, data.coverUrl, wappage_book_img);
//        wappage_book_name.setText(data.title);
//        wappage_book_auth.setText(data.authorname);
//        wappage_book_content.setText(data.intro);
//
//    }
//
//    private void close() {
//        parentView.removeView(contentView);
//        if (listener != null) {
//            listener.close();
//        }
//    }
//
//    public void getWappage(String cbid) {
////        QianYueApi.getApiService().getWappage(cbid)
////                .compose(XApi.<WappageData>getApiTransformer())
////                .compose(XApi.<WappageData>getScheduler())
////                .subscribe(new ApiSubcriber<WappageData>() {
////                    @Override
////                    protected void onFail(NetError error) {
////                        close();
////                    }
////
////                    @Override
////                    public void onNext(WappageData bean) {
////
////                        if (ConfigUtils.SUCCESS.equals(bean.getResult())) {
////                            data = bean.data;
////                            bookBean.setWappageData(new Gson().toJson(data));
////                            BookDetailsBeanHelper.getsInstance().saveBook(bookBean);
////                            initData(data);
////                        } else {
////
////                            close();
////                        }
////                    }
////                });
//    }
//
//    public void setData() {
//    }
//
//    StateListener listener;
//
//    public void setOnStateListener(StateListener listener) {
//        this.listener = listener;
//    }
//
//    public interface StateListener {
//        void close();
//    }
//}
