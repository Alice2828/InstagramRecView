package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.TargetApi;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    static List<News> items = new ArrayList<>();
    static List<News> likedNews = new ArrayList<>();
    private Toolbar toolbar;
    private MenuItem prevMenuItem;
    private BottomNavigationView bottomNavigationView;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView=findViewById(R.id.bottom_navigation);


        ArrayList<Integer> logo = new ArrayList<>();
        ArrayList<String> author = new ArrayList<>();
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        logo.add(R.drawable.log);
        author.add("aggressive_deer");
        image.add(R.drawable.im);
        data.add("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");

        logo.add(R.drawable.logo);
        author.add("pankirei");
        image.add(R.drawable.ima);
        data.add("Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots in a piece of classical Latin literature from 45 BC, " +
                "making it over 2000 years old. Richard McClintock, a Latin professor " +
                "at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, " +
                "consectetur, from a Lorem Ipsum passage, and going through the cites of the word " +
                "in classical literature, discovered the undoubtable source.");

        logo.add(R.drawable.logot);
        author.add("muragulka_2000");
        image.add(R.drawable.imag);
        data.add("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, " +
                "or randomised words which don't look even slightly believable." +

                " If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. ");

        logo.add(R.drawable.logoty);
        author.add("MuragerTop");
        image.add(R.drawable.image);
        data.add("The standard chunk of Lorem Ipsum used since the 1500s is reproduced below" +
                " for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by C" +
                "icero are also reproduced in" +
                " their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");

        logo.add(R.drawable.logotyp);
        author.add("kosmetosic");
        image.add(R.drawable.pi);
        data.add("Donate: If you use this site regularly and would like to help " +
                "keep the site on the Internet, please consider donating a small sum to help pay for the hosting and bandwidth bill. " +
                "There is no minimum donation, any sum is appreciated - click here to donate using PayPal. Thank you for your support.");

        logo.add(R.drawable.logotype);
        author.add("nogotochki");
        image.add(R.drawable.pic);
        data.add("There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...");

        logo.add(R.drawable.loglog);
        author.add("almaty_kk");
        image.add(R.drawable.pict);
        data.add("Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for" +
                " lorem ipsum will uncover many web sites still in their infancy. " +
                "Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");

        logo.add(R.drawable.loglogl);
        author.add("what_If");
        image.add(R.drawable.pictu);
        data.add("But I must explain to you how all this mistaken idea of" +
                " denouncing pleasure and praising pain was born and I will " +
                "give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, " +
                "the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, " +

                "because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. ");

        logo.add(R.drawable.loo);
        author.add("laLala");
        image.add(R.drawable.pictur);
        data.add("On the other hand, we denounce with righteous indignation" +
                " and dislike men who are so beguiled and demoralized by the charms of pleasure" +
                " of the moment, so blinded by desire, that they cannot foresee the pain and trouble" +
                " that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, " +
                "which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. " +
                "In a free hour, when our power of choice is" +
                " untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. ");

        logo.add(R.drawable.logoo);
        author.add("Love");
        image.add(R.drawable.picture);
        data.add("But in certain circumstances and owing to the claims of duty or the obligations of " +
                "business it will frequently occur that pleasures have to be repudiated and annoyances" +
                " accepted. The wise man therefore always holds in these matters " +
                "to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.");
        for (int i = 0; i < logo.size(); i++) {
            News news = new News(
                    logo.get(i),
                    author.get(i),
                    image.get(i),
                    data.get(i),
                    i,
                    i
            );
            items.add(news);
        }


        List<Fragment> list = new ArrayList<Fragment>();

        PageFragment pagefragment = new PageFragment(items);

        FragmentLike fragment = new FragmentLike(items);

        list.add(pagefragment);
        list.add(fragment);



        pager = findViewById(R.id.pager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);
        List<ImageButton> imgBtn;


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                pager.setCurrentItem(0);

                                break;
                            case R.id.navigation_likes:
                                pager.setCurrentItem(1);

                            break;

                        }
                        return false;
                    }
                });


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
//    @Override
//    public void onBackPressed() {
//        if (pager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            pager.setCurrentItem(pager.getCurrentItem() - 1);
//        }
//    }

