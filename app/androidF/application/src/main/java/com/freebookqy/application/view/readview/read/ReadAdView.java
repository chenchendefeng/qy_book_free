//package com.freebookqy.application.view.readview.read;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//import com.freebookqy.application.R;
//import com.freebookqy.application.app.ADManager;
//
//public class ReadAdView {
//    Context mContext;
//    View parentView;
//    View contentView;
//
//    public ReadAdView() {
//
//    }
//
//    public void create(ViewGroup parentView) {
//        mContext = parentView.getContext();
//        contentView = LayoutInflater.from(mContext).inflate(R.layout.read_page_ad, null);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        parentView.addView(contentView, params);
//        ADManager
//                .displayNativeExpressAD(
//                        mContext,
//                        contentView.findViewById(R.id.ad_content),
//                        ADManager.POSID_READ,
//                        new ADManager.NativeADListener() {
//                            @Override
//                            public void onADClosed() {
//                                parentView.removeView(contentView);
//                                if (listener != null) {
//                                    listener.close();
//                                }
//                            }
//
//                            @Override
//                            public void onNoAD() {
//
//                            }
//                        });
//        contentView.findViewById(R.id.ad_skip1).setOnClickListener(v -> {
//            parentView.removeView(contentView);
//            if (listener != null) {
//                listener.close();
//            }
//        });
//        contentView.findViewById(R.id.ad_skip2).setOnClickListener(v -> {
//            parentView.removeView(contentView);
//            if (listener != null) {
//                listener.close();
//            }
//        });
//    }
//
//    ReadWappageView.StateListener listener;
//
//    public void setOnStateListener(ReadWappageView.StateListener listener) {
//        this.listener = listener;
//    }
//
//    public interface StateListener {
//        void close();
//    }
//}
