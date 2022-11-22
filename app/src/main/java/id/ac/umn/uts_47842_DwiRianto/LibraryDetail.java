package id.ac.umn.uts_47842_DwiRianto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class LibraryDetail extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    List<String> listData;
    Toolbar my_toolbar;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_page);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();
        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setTitle("Hello, " + name);
        my_toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(my_toolbar);
        recyclerView = findViewById(R.id.recycleData);
        listData = new ArrayList<>();

        for(int i = 1; i < 10; i++){
            listData.add("Video " + i);
        }

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterData = new AdapterData(this, listData,name);
        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();
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
