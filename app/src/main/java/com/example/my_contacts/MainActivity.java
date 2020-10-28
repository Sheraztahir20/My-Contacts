package com.example.my_contacts;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.ImageView;
        import android.widget.ViewFlipper;

        import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        final home home = new home();
        final contact contact = new contact();
        final profile profile = new profile();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    setFragment(home);
                    return true;
                } else if (id == R.id.contact) {
                    setFragment(contact);
                    return true;
                } else if (id == R.id.profile) {
                    setFragment(profile);
                    return true;
                }

                return false;
            }

            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.commit();

            }

        });


        int images[] = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
        viewFlipper =

                findViewById(R.id.flipper);
        for(
                int image:images)

            flipperimages(image);

    }

    private void flipperimages(int image) {
        ImageView imageView = new ImageView (this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setInAnimation(this,android.R.anim.slide_out_right);

    }
}