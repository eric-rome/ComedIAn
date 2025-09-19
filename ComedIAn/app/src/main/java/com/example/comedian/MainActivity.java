package com.example.comedian;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthCredential;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnEmoji;
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encuentra el ImageButton por su ID
        btnEmoji = findViewById(R.id.btnSpeechToText);

        // Agrega un OnClickListener al botón
        btnEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si el temporizador está en marcha
                if (!isTimerRunning) {
                    // Cambia la imagen del emoji al ser presionado
                    btnEmoji.setImageResource(R.drawable.laughingmore_emoji_svgrepo_com);

                    // Inicia el temporizador de 5 segundos
                    startTimer();

                    // Indica que el temporizador está en marcha
                    isTimerRunning = true;
                }
            }
        });
    }

    private void startTimer() {
        new CountDownTimer(5000, 1000) { // Temporizador de 5 segundos con intervalos de 1 segundo
            @Override
            public void onTick(long millisUntilFinished) {
                // No necesitas hacer nada en cada intervalo (tick) del temporizador
            }

            @Override
            public void onFinish() {
                // Restaura la imagen original del emoji después de que el temporizador finalice
                btnEmoji.setImageResource(R.drawable.laughing_emoji_svgrepo_com);

                // Indica que el temporizador ha finalizado
                isTimerRunning = false;
            }
        }.start(); // Inicia el temporizador
    }
}
