package com.sean.rsa_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sean.rsa_test.Util.RSACipher;

import java.util.concurrent.ExecutorCompletionService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText editTxt;
    TextView txtEncripted, txtDecripted;

    RSACipher cipher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.edit_txt);
        txtEncripted = findViewById(R.id.txt_encripted);
        txtDecripted = findViewById(R.id.txt_decripted);
    }

    public void onCipher(View view) {

        Log.d(TAG, "onCipher");
        try {
            cipher = new RSACipher();
            String strToBeEncripted = editTxt.getText().toString();
            Log.d(TAG, "strToBeEncripted: " + strToBeEncripted);

            String encrypt = cipher.encrypt(strToBeEncripted);
            Log.d(TAG, "encrypt: " + encrypt);
            txtEncripted.setText(encrypt);

            String decrypt = cipher.decrypt(encrypt);
            Log.d(TAG, "decrypt: " + decrypt);
            txtDecripted.setText(decrypt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
