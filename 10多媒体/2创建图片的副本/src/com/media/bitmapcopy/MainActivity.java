package com.media.bitmapcopy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //���������ֻ����,����ͼƬ�Ƚ�С�����Բ���ѹ��
        Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/photo3.jpg");
        
        //����ͼƬ����
        //1.���ڴ��д���һ����ԭͼһģһ����С��bitmap���󣬴�����ԭͼ��Сһ�µİ�ֽ
        Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        
        //2.�������ʶ���
        Paint paint = new Paint();
        
        //3.����������󣬰Ѱ�ֽ���ڻ�����
        Canvas canvas = new Canvas(bmCopy);
        
        //4.��ʼ��������ԭͼ�����ݻ����ڰ�ֽ��
        canvas.drawBitmap(bmSrc, new Matrix(), paint);
        
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_src.setImageBitmap(bmSrc);
        iv_copy.setImageBitmap(bmCopy);
    }
}
