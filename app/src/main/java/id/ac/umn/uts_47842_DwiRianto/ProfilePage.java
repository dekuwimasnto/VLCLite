package id.ac.umn.uts_47842_DwiRianto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class ProfilePage extends AppCompatActivity {
    Toolbar my_toolbar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        my_toolbar2 = findViewById(R.id.profile_toolbar);
        setSupportActionBar(my_toolbar2);
        my_toolbar2.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_back_hitam));
        my_toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
