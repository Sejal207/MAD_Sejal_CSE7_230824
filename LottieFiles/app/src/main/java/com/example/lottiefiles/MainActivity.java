package com.example.lottiefiles;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView lottieAnimationView;
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        btnPlay = findViewById(R.id.btnPlay);

        // Set click listener
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lottieAnimationView.isAnimating()) {
                    lottieAnimationView.pauseAnimation();
                    btnPlay.setText("Play");
                } else {
                    lottieAnimationView.playAnimation();
                    btnPlay.setText("Pause");
                }
            }
        });
    }
}