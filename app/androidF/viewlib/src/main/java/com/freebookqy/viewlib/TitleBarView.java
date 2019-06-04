package com.freebookqy.viewlib;


import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TitleBarView extends FrameLayout {

    private static final String TAG = "TitleBarView";
    private TextView viewTitleText;
    private View buttonLeft, buttonRight;
    private TextView viewTextLeft, viewTextRight;
    private ImageView viewImageLeft, viewImageRight;
    private View viewDivider;
    private RelativeLayout titleBar;
    private ImageView titleIcon;

    public TitleBarView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View.inflate(context, R.layout.layout_title_bar, this);

        if (isInEditMode())
            return;
        String titleName = null;
        int titleTextColor = 0;
        int titleBg = 0;
        String leftText_str = null;
        int leftText_res = 0;
        int leftImage = 0;
        String rightText_str = null;
        int rightText_res = 0;
        int rightImage = 0;

        int leftTextColor = 0;
        int rightTextColor = 0;

        boolean isShowLine = true;
        if (attrs != null) {
            TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBarView);
            titleName = t.getString(R.styleable.TitleBarView_title_text);
            titleTextColor = t.getResourceId(R.styleable.TitleBarView_title_text_color, 0);
            titleBg = t.getResourceId(R.styleable.TitleBarView_title_bg, 0);

            leftText_str = t.getString(R.styleable.TitleBarView_left_text);
            leftText_res = t.getResourceId(R.styleable.TitleBarView_left_text, 0);
            leftImage = t.getResourceId(R.styleable.TitleBarView_left_image, 0);

            rightText_str = t.getString(R.styleable.TitleBarView_right_text);
            rightText_res = t.getResourceId(R.styleable.TitleBarView_right_text, 0);
            rightImage = t.getResourceId(R.styleable.TitleBarView_right_image, 0);

            leftTextColor = t.getResourceId(R.styleable.TitleBarView_left_text_color, 0);
            rightTextColor = t.getResourceId(R.styleable.TitleBarView_right_text_color, 0);
            isShowLine = t.getBoolean(R.styleable.TitleBarView_line_divide, true);
            t.recycle();
        }
        this.viewTitleText = (TextView) findViewById(R.id.viewTitleText);
        this.buttonLeft = findViewById(R.id.buttonLeft);
        this.buttonRight = findViewById(R.id.buttonRight);
        this.viewTextLeft = (TextView) findViewById(R.id.viewTextLeft);
        this.viewTextRight = (TextView) findViewById(R.id.viewTextRight);
        this.viewImageLeft = (ImageView) findViewById(R.id.viewImageLeft);
        this.viewImageRight = (ImageView) findViewById(R.id.viewImageRight);
        this.viewDivider = findViewById(R.id.viewDivider);
        this.titleBar = (RelativeLayout) findViewById(R.id.title_bar);
        this.titleIcon = (ImageView) findViewById(R.id.title_icon);
        if (!TextUtils.isEmpty(titleName)) {
            setTitleText(titleName);
        }
        if (titleTextColor != 0) {
            int titleColor = getContext().getResources().getColor(titleTextColor);
            setTitleTextColor(titleColor);
        }

        if (!TextUtils.isEmpty(leftText_str)) {
            setLeftText(leftText_str);
        }
        if (!TextUtils.isEmpty(rightText_str)) {
            setRightText(rightText_str);
        }
        if (leftText_res != 0) {
            setLeftText(leftText_res);
        }
        if (rightText_res != 0) {
            setRightText(rightText_res);
        }
        if (leftImage != 0) {
            setLeftImage(leftImage);
        }
        if (rightImage != 0) {
            setRightImage(rightImage);
        }
        if (leftTextColor != 0) {
            setLeftTextColor(leftTextColor);
        }
        if (rightTextColor != 0) {
            setRightTextColor(rightTextColor);
        }
        if (titleBg != 0) {
            setTitleBarBg(titleBg);
        }
        showDivideLine(isShowLine ? View.VISIBLE : View.INVISIBLE);
    }

    public ImageView getTitleIcon() {
        return titleIcon;
    }

    // 标题
    public void setTitleText(int resId) {
        this.viewTitleText.setVisibility(VISIBLE);
        this.viewTitleText.setText(resId);
    }

    public void setTitleText(String text) {
        this.viewTitleText.setVisibility(VISIBLE);
        this.viewTitleText.setText(text);
    }

    public void setTitleTextColor(int color) {
        this.viewTitleText.setTextColor(color);
    }

    public void setTitleBarBg(int color) {
        titleBar.setBackgroundResource(color);
    }

    public void showDivideLine(int visibilty) {
        viewDivider.setVisibility(visibilty);
    }

    // 左按钮
    public void setLeftText(int resId) {
        this.viewTextLeft.setText(resId);
        innerShowLeftButtonImage(false);
    }

    public void setLeftText(String text) {
        this.viewTextLeft.setText(text);
        innerShowLeftButtonImage(false);
    }

    public void setLeftTextColor(int color) {
        this.viewTextLeft.setTextColor(getContext().getResources().getColor(color));
    }

    //	public void setLeftIcon(int resId) {
    //		this.viewTextLeft.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0);
    //	}

    public void setLeftImage(int resId) {
        this.viewImageLeft.setImageResource(resId);
        innerShowLeftButtonImage(true);
    }


    public void setLeftVisible(boolean visible) {
        if (visible) {
            this.buttonLeft.setVisibility(View.VISIBLE);
        } else {
            this.buttonLeft.setVisibility(View.INVISIBLE);
        }
    }

    public void setLeftEnabled(boolean enabled) {
        buttonLeft.setEnabled(enabled);
    }

    public void setOnLeftButtonClickListener(OnClickListener listener) {
        this.buttonLeft.setOnClickListener(listener);
    }

    // 右按钮
    public void setRightText(int resId) {
        this.viewTextRight.setText(resId);
        innerShowRightButtonImage(false);
    }

    public void setRightText(String text) {
        this.viewTextRight.setText(text);
        innerShowRightButtonImage(false);
    }

    public void setRightTextColor(int color) {
        this.viewTextRight.setTextColor(getContext().getResources().getColor(color));
    }

    //	public void setRightIcon(int resId) {
    //		this.viewTextRight
    //				.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0);
    //	}


    public TextView getViewTitleText() {
        return viewTitleText;
    }

    public void setRightImage(int resId) {
        this.viewImageRight.setImageResource(resId);
        innerShowRightButtonImage(true);
    }

    public void setRightVisible(boolean visible) {
        if (visible) {
            this.buttonRight.setVisibility(View.VISIBLE);
        } else {
            this.buttonRight.setVisibility(View.INVISIBLE);
        }
    }

    public void setRightEnabled(boolean enabled) {
        buttonRight.setClickable(enabled);
        buttonRight.setEnabled(enabled);
        viewTextRight.setEnabled(enabled);
        viewTextRight.setClickable(enabled);
    }

    public void setOnRightButtonClickListener(OnClickListener listener) {
        this.buttonRight.setOnClickListener(listener);
    }

    // 分割线
    public void setDividerVisible(boolean visible) {
        if (visible) {
            this.viewDivider.setVisibility(View.VISIBLE);
        } else {
            this.viewDivider.setVisibility(View.GONE);
        }
    }

    private void innerShowLeftButtonImage(boolean visible) {
        if (visible) {
            this.viewTextLeft.setVisibility(View.GONE);
            this.viewImageLeft.setVisibility(View.VISIBLE);

        } else {
            this.viewTextLeft.setVisibility(View.VISIBLE);
            this.viewImageLeft.setVisibility(View.GONE);
        }
    }

    private void innerShowRightButtonImage(boolean visible) {
        if (visible) {
            this.viewTextRight.setVisibility(View.GONE);
            this.viewImageRight.setVisibility(View.VISIBLE);

        } else {
            this.viewTextRight.setVisibility(View.VISIBLE);
            this.viewImageRight.setVisibility(View.GONE);
        }
    }


}
