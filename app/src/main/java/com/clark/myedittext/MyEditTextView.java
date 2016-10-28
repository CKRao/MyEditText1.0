package com.clark.myedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by clark on 2016/10/28.
 */

public class MyEditTextView extends RelativeLayout {
    private TextView titleText;
    private String titleTextString;
    private float textSize;
    private EditText mEditText;
    private View mView;
    private int viewColor;
    private String mEditTextHint;
    private ImageView mImageView;
    public MyEditTextView(Context context) {
        this(context,null);
    }

    public MyEditTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context,R.layout.edittext_layout,this);
        titleText = (TextView) findViewById(R.id.id_text1);
        mView =findViewById(R.id.view1);
        mEditText = (EditText)findViewById(R.id.id_et);
        mImageView = (ImageView)findViewById(R.id.id_img);
        initAttrs(attrs,context);
        titleText.setText(titleTextString);
        mView.setBackgroundColor(viewColor);
        mEditText.setHint(mEditTextHint);
        titleText.setTextSize(textSize);
        setEditTextListener(context);
    }

    private void setEditTextListener(Context context) {
        mEditText.addTextChangedListener( new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 监听如果输入串长度大于0那么就显示clear按钮。
                String s1 = s + "";
                if (s.length()>0){
                    mImageView.setVisibility(View.VISIBLE);
                }else {
                    mImageView.setVisibility(View.INVISIBLE);
                }
            }
        });
        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
            }
        });
    }

    private void initAttrs(AttributeSet attrs, Context context) {
        //从attrs文件中获取属性
        TypedArray ta= context.obtainStyledAttributes(attrs,R.styleable.MyEsitText);
        //从TypedArray中取出对应的值来为属性赋值
        titleTextString = ta.getString(R.styleable.MyEsitText_leftText);
        mEditTextHint = ta.getString(R.styleable.MyEsitText_editHint);
        viewColor = ta.getColor(R.styleable.MyEsitText_viewColor,0);
        textSize = ta.getDimension(R.styleable.MyEsitText_leftTextSize,10);

    }


}
