package vn.namle.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String publicKeyBytesBase64;
    private String privateKeyBytesBase64;
    private String encrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        publicKeyBytesBase64 = Encryption.getPublicKey();
        privateKeyBytesBase64 = Encryption.getPrivateKey();

        findViewById(R.id.btn_encryption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // test encryption
                String dataToEncrypt = ((EditText) findViewById(R.id.data_encode)).getText().toString().trim();
                encrypted = Encryption.encryptRSAToString(dataToEncrypt, publicKeyBytesBase64);
                findViewById(R.id.btn_decryption).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.btn_decryption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // test decryption
                String decrypted = Encryption.decryptRSAToString(encrypted, privateKeyBytesBase64);
                Toast.makeText(getBaseContext(), decrypted, Toast.LENGTH_SHORT).show();
            }
        });
    }
}