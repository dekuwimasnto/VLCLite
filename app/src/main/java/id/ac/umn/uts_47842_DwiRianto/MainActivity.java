package id.ac.umn.uts_47842_DwiRianto;


import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button btnprofile, btnlibrary, btnlogin;
    EditText EditTextName;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnprofile = findViewById(R.id.btnprofile);
        btnlibrary = findViewById(R.id.btnlibrary);

        btnprofile.setOnClickListener(v2 -> {
            Intent intent = new Intent(MainActivity.this, ProfilePage.class);
            startActivity(intent);
        });

        btnlibrary.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.show();
            btnlogin = dialog.findViewById(R.id.btnlogin);
            EditTextName = dialog.findViewById(R.id.EditTextName);

            btnlogin.setOnClickListener(v1 -> {
                String name = EditTextName.getText().toString();
                if (name.isEmpty()) {
                    View view = findViewById(R.id.btnlibrary);
                    String mesage = "Name must be entered";
                    int duration = Snackbar.LENGTH_SHORT;
                    showToast(view, mesage, duration);
                } else {
                    dialog.dismiss();
                    Intent intent = new Intent(MainActivity.this, LibraryDetail.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            });
        });
    }
    public void showToast(View view, String message, int duration)
    {
        Toast.makeText(this, message, duration).show();
    }
}