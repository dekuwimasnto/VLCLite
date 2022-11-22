package id.ac.umn.uts_47842_DwiRianto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class DetailFile extends AppCompatActivity {
    public String name;
    public String videoName;

    Toolbar my_toolbar;
    VideoView videoView;
    TextView tvJudul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_video);
        Intent intent = getIntent();
        tvJudul = findViewById(R.id.tvJudul);
        name = intent.getStringExtra("name");
        videoName = intent.getStringExtra("nameVideo");
        tvJudul.setText(videoName);
        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setTitle("Detail Video");
        my_toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(my_toolbar);
        my_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_back_putih));
        my_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailFile.this, LibraryDetail.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        MediaController mediaController = new MediaController(this);

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.detail_video);
        videoView.setMediaController(mediaController);

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Video Error", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        videoView.start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profil:
                goToProfil();
                return true;
            case R.id.kembali:
                GotoHome();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToProfil() {
        Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
        startActivity(intent);
    }

    private void GotoHome() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
