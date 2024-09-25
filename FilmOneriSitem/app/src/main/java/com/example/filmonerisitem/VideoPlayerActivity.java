package com.example.filmonerisitem;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

// VideoPlayerActivity sınıfı, video oynatma ekranını temsil eder.
public class VideoPlayerActivity extends AppCompatActivity {
    private SimpleExoPlayer simpleExoPlayer;  // ExoPlayer nesnesi
    private PlayerView videoPlayer;            // Video oynatıcı görünümü
    private ProgressBar progressBar;           // Video yüklenirken gösterilen ilerleme çubuğu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ekranın üstündeki başlık çubuğunu gizleme ve tam ekran modunu ayarlama
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);  // Video oynatıcı aktivitesinin içeriğini belirleme

        // XML dosyasındaki bileşenleri Java koduna bağlama
        videoPlayer = findViewById(R.id.exo_player);
        progressBar = findViewById(R.id.progress_bar);

        // ExoPlayer ile videoyu ayarla
        setUpExoPlayer(getIntent().getStringExtra("url"));
    }

    // ExoPlayer'ı ayarlayan metod
    private void setUpExoPlayer(String url) {
        LoadControl loadControl = new DefaultLoadControl();  // Video yüklenirken kontrolü sağlayan nesne
        DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);  // Video izleme seçeneklerini yöneten nesne

        // SimpleExoPlayer nesnesini oluşturma ve ayarlama
        simpleExoPlayer = new SimpleExoPlayer.Builder(this)
                .setTrackSelector(trackSelector)
                .setLoadControl(loadControl)
                .build();

        videoPlayer.setPlayer(simpleExoPlayer);  // Video oynatıcısına ExoPlayer nesnesini bağlama

        // Veri kaynağı oluşturma ve ExoPlayer'a ekleme
        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "movieapp"));
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url));

        simpleExoPlayer.addMediaSource(mediaSource);  // ExoPlayer'a medya kaynağını ekleme

        // ExoPlayer olay dinleyicisi ekleme
        simpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onPlayerError(PlaybackException error) {
                // Video oynatma sırasında bir hata olursa burada işlemler yapabilirsiniz.
            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                // Oynatma durumu değiştiğinde yapılacak işlemler
                if (playbackState == Player.STATE_BUFFERING) {
                    progressBar.setVisibility(View.VISIBLE);  // Video yüklenirken ilerleme çubuğunu gösterme
                } else if (playbackState == Player.STATE_READY) {
                    progressBar.setVisibility(View.GONE);     // Video oynatılmaya hazır olduğunda ilerleme çubuğunu gizleme
                }
            }
        });

        simpleExoPlayer.prepare();          // ExoPlayer'ı hazırlama
        simpleExoPlayer.setPlayWhenReady(true);  // Video oynatmaya hazır olduğunda otomatik olarak oynatma
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();  // Video oynatıcıyı serbest bırakma
        }
    }
}
