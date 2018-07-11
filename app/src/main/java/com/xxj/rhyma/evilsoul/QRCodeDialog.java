package com.xxj.rhyma.evilsoul;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ASUS User on 2018/7/10.
 */

public class QRCodeDialog extends Dialog {

    private ImageView iv;
    private Context context;

    public QRCodeDialog(@NonNull Context context) {
        super(context, R.style.fullscreenDialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_qrcode);
        setCanceledOnTouchOutside(true);
        iv = findViewById(R.id.iv);
    }

    public QRCodeDialog wechat() {
        if (iv==null) {
            return this;
        }
        iv.setImageDrawable(context.getResources().getDrawable(R.mipmap.qr_wechat));
        return this;
    }

    public QRCodeDialog alipay() {
        if (iv==null) {
            return this;
        }
        iv.setImageDrawable(context.getResources().getDrawable(R.mipmap.qr_alipay));
        return this;
    }
}
