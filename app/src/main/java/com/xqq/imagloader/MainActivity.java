package com.xqq.imagloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.xqq.imagloader.utils.DiskCache;
import com.xqq.imagloader.utils.DoubleCache;
import com.xqq.imagloader.utils.ImageLoader;
import com.xqq.imagloader.utils.MemoryCache;

public class MainActivity extends AppCompatActivity {

    private ImageLoader mImageLoder;
    private EditText mImageAddress;
    private ImageView mLoadImage;
    private RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_memoryCache){
                    mImageLoder.setmImageCache(new MemoryCache());
                }else if(checkedId == R.id.rb_diskCache){
                    mImageLoder.setmImageCache(new DiskCache());
                }else if(checkedId == R.id.rb_doubleCache){
                    mImageLoder.setmImageCache(new DoubleCache());
                }
            }
        });
    }

    private void init(){
        mImageLoder = new ImageLoader();
        findViewById();
    }
    private void findViewById(){
        mImageAddress = (EditText) findViewById(R.id.et_imageAddress);
        mLoadImage = (ImageView) findViewById(R.id.image_cache);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void click(View view){
        String address = mImageAddress.getText().toString().trim();
        if(null != address) {
            mImageLoder.displayImage(address, mLoadImage);
        }
    }
}