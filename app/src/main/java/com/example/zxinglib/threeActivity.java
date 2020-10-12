package com.example.zxinglib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CodeUtils;

public class threeActivity extends AppCompatActivity {
    public EditText editText;
    public Button button1;
    public Button button2;
    public ImageView imageView;
    public Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initView();
    }

private void initView(){
        editText = (EditText) findViewById(R.id.edit_content);
        button1 = (Button) findViewById(R.id.edit_button);
        button2 = (Button) findViewById(R.id.edit_button2);
        imageView = (ImageView) findViewById(R.id.image_content);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)){
                    Toast.makeText(threeActivity.this,"您的输入为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                bitmap = CodeUtils.createImage(textContent,400,400, BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                imageView.setImageBitmap(bitmap);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)){
                    Toast.makeText(threeActivity.this,"您的输入为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                bitmap = CodeUtils.createImage(textContent,400,400,null);
                imageView.setImageBitmap(bitmap);
            }
        });

}
}