package com.hy.issaclibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author issac
 * @version 1.0.0
 * @Description
 * @Date 2020/7/2 14:49
 */
public class SettingItemBar extends RelativeLayout {

    RelativeLayout mRelativeLayout;//布局
    private ImageView mIconIV;//最左侧图标
    private int icon;//图标对应资源id
    private int iconVisibility;//图标可见性
    private String titleText;//标题文字
    private TextView mTitleTextTV;//标题文字对应的TextView
    private int titleTextVisibility;//标题可见性
    private String infoText;//信息文字
    private TextView mInfoTextTV;//信息文字对应的TextView
    private int infoTextVisibility;//信息可见性
    private ImageView mForwardIV;//最左侧图标
    private int forward;//最左侧图标对应资源id
    private int forwardVisibility;//最左侧图标可见性
    private int backgroundColor;//背景颜色

    /*
    构造函数，参数一：上下文；参数二：属性集
     */
    public SettingItemBar(Context context, AttributeSet attrs){
        super(context,attrs);
        //加载自定义布局
        LayoutInflater.from(context).inflate(R.layout.setting_item_bar,this);
        //实例化组件
        mIconIV = (ImageView) findViewById(R.id.icon);
        mForwardIV = (ImageView) findViewById(R.id.forward);
        mTitleTextTV = (TextView)findViewById(R.id.title_text);
        mInfoTextTV = (TextView)findViewById(R.id.text);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);

        /*
            每一个属性集合编译之后都会对应一个styleable对象,
            通过styleable对象获取TypedArray typedArray，然后通过键值对获取属性值。
            R.styleable.SettingsItemLayout,SettingsItemLayout对应attrs里面属性集的名称而不是本类的类名
         */
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItemBar);
        if (typedArray != null) {
            titleText = typedArray.getString(R.styleable.SettingItemBar_title_text);
            titleTextVisibility = typedArray.getInt(R.styleable.SettingItemBar_title_text_visibility,0);
            infoText = typedArray.getString(R.styleable.SettingItemBar_info_text);
            infoTextVisibility = typedArray.getInt(R.styleable.SettingItemBar_info_text_visibility,0);
            icon = typedArray.getResourceId(R.styleable.SettingItemBar_icon_iv,R.drawable.setting);
            iconVisibility = typedArray.getInt(R.styleable.SettingItemBar_icon_iv_visibility,0);
            forward = typedArray.getResourceId(R.styleable.SettingItemBar_forward_iv,R.drawable.forward);
            forwardVisibility = typedArray.getInt(R.styleable.SettingItemBar_forward_iv_visibility,0);
            backgroundColor = typedArray.getColor(R.styleable.SettingItemBar_background_color,getResources().getColor(R.color.nav_bar_background));
            typedArray.recycle();
        }
        //将自定义的属性值设置到组件上
        mTitleTextTV.setText(titleText);
        mTitleTextTV.setVisibility(titleTextVisibility);
        mInfoTextTV.setText(infoText);
        mInfoTextTV.setVisibility(infoTextVisibility);
        mIconIV.setImageResource(icon);
        mIconIV.setVisibility(iconVisibility);
        mForwardIV.setImageResource(forward);
        mForwardIV.setVisibility(forwardVisibility);
        mRelativeLayout.setBackgroundColor(backgroundColor);
        //点击事件
        mIconIV.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                iconOICL.OnClick();
            }
        });
        mTitleTextTV.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                titleOICL.OnClick();
            }
        });
        mInfoTextTV.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                infoOICL.OnClick();
            }
        });
        mForwardIV.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                forwardOICL.OnClick();
            }
        });
    }

    //设置标题内容及颜色，参数为字符串或者资源id或者颜色
    public void setTitleText(String titleText){
        mTitleTextTV.setText(titleText);
    }

    public void setTitleText(int titleText){
        mTitleTextTV.setText(titleText);
    }

    public void setTitleTextColor(int color){
        mTitleTextTV.setTextColor(color);
    }

    //设置标题文本样式 0 normal 1 bold 2 italic
    public void setTitleStyle(int style){
        switch (style){
            case 0:
                mTitleTextTV.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                break;
            case 1:
                mTitleTextTV.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                break;
            case 2:
                mTitleTextTV.setTypeface(Typeface.DEFAULT,Typeface.ITALIC);
                break;
            default:
                break;
        }
    }

    //设置信息内容及颜色，参数为字符串或者资源id或者颜色
    public void setInfoText(String infoText){
        mInfoTextTV.setText(infoText);
    }

    public void setInfoText(int infoText){
        mInfoTextTV.setText(infoText);
    }

    public void setInfoTextColor(int color){
        mInfoTextTV.setTextColor(color);
    }

    //设置信息文本样式 0 normal 1 bold 2 italic
    public void setInfoStyle(int style){
        switch (style){
            case 0:
                mInfoTextTV.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                break;
            case 1:
                mInfoTextTV.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                break;
            case 2:
                mInfoTextTV.setTypeface(Typeface.DEFAULT,Typeface.ITALIC);
                break;
            default:
                break;
        }
    }

    //设置两侧图标及布局背景颜色
    public void setIconIV(int id){
        mIconIV.setImageResource(id);
    }

    public void setForwardIV(int id){
        mForwardIV.setImageResource(id);
    }

    public  void setBackground(int color){
        mRelativeLayout.setBackgroundColor(color);
    }

    //设置组件的可见性 8 GONE 4 INVISIBLE 0 VISIBLE
    public void setIconIVVisibility(int flag){
        switch (flag){
            case 8:
                mIconIV.setVisibility(GONE);
                break;
            case 4:
                mIconIV.setVisibility(INVISIBLE);
                break;
            case 0:
                mIconIV.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
    }

    public void setForwardIVVisibility(int flag){
        switch (flag){
            case 8:
                mForwardIV.setVisibility(GONE);
                break;
            case 4:
                mForwardIV.setVisibility(INVISIBLE);
                break;
            case 0:
                mForwardIV.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
    }

    public void setTitleTextTVVisibility(int flag){
        switch (flag){
            case 8:
                mTitleTextTV.setVisibility(GONE);
                break;
            case 4:
                mTitleTextTV.setVisibility(INVISIBLE);
                break;
            case 0:
                mTitleTextTV.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
    }

    public void setInfoTextTVVisibility(int flag){
        switch (flag){
            case 8:
                mInfoTextTV.setVisibility(GONE);
                break;
            case 4:
                mInfoTextTV.setVisibility(INVISIBLE);
                break;
            case 0:
                mInfoTextTV.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
    }

    //定义点击事件接口
    public interface OnItemClickListener{
        void OnClick();
    }

    //实例化
    private OnItemClickListener iconOICL = new OnItemClickListener() {
        @Override
        public void OnClick() {

        }
    };
    private OnItemClickListener titleOICL = new OnItemClickListener() {
        @Override
        public void OnClick() {

        }
    };
    private OnItemClickListener infoOICL = new OnItemClickListener() {
        @Override
        public void OnClick() {

        }
    };
    private OnItemClickListener forwardOICL = new OnItemClickListener() {
        @Override
        public void OnClick() {

        }
    };

    //设置点击事件的回调 0 左侧图标 1 标题 2 信息 3 右侧图标
    public void setOnItemClickListener(OnItemClickListener on,int type){
        switch (type){
            case 0:
                iconOICL = on;
                break;
            case 1:
                titleOICL = on;
                break;
            case 2:
                infoOICL = on;
                break;
            case 3:
                forwardOICL = on;
                break;
            default:
                break;
        }
    }

}
