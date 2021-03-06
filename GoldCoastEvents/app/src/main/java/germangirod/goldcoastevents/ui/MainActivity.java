package germangirod.goldcoastevents.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import germangirod.goldcoastevents.util.Constants;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.EventResponse;
import germangirod.goldcoastevents.data.presenter.EventsPresenter;
import germangirod.goldcoastevents.ui.fragments.ActiveEventFragment;
import germangirod.goldcoastevents.ui.fragments.ArtEventFragment;
import germangirod.goldcoastevents.ui.fragments.FamilyEventFragment;
import germangirod.goldcoastevents.ui.fragments.FoodEventFragment;
import germangirod.goldcoastevents.ui.fragments.GeneralEventFragment;
import germangirod.goldcoastevents.ui.fragments.MusicEventFragment;
import germangirod.goldcoastevents.ui.fragments.SeniorEventFragment;
import germangirod.goldcoastevents.ui.fragments.SportEventFragment;

public class MainActivity extends AppCompatActivity implements EventsPresenter {

    private MaterialViewPager mViewPager;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        toolbar.setTitle("");
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return ActiveEventFragment.newInstance();
                    case 1:
                        return ArtEventFragment.newInstance();
                    case 2:
                        return FamilyEventFragment.newInstance();
                    case 3:
                        return FoodEventFragment.newInstance();
                    case 4:
                        return GeneralEventFragment.newInstance();
                    case 5:
                        return MusicEventFragment.newInstance();
                    case 6:
                        return SportEventFragment.newInstance();
                    case 7:
                        return SeniorEventFragment.newInstance();
                    default:
                        return null;
                }
            }

            @Override public int getCount() {
                return 8;
            }

            @Override public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return Constants.ACTIVE_CATEGORY;
                    case 1:
                        return Constants.ART_CATEGORY;
                    case 2:
                        return Constants.FAMILY_CATEGORY;
                    case 3:
                        return Constants.FOOD_CATEGORY;
                    case 4:
                        return Constants.GENERAL_CATEGORY;
                    case 5:
                        return Constants.MUSIC_CATEGORY;
                    case 6:
                        return Constants.SPORT_CATEGORY;
                    case 7:
                        return Constants.SENIOR_CATEGORY;
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(R.color.green,
                                "http://www.eatcleanlivehealthy.com/wp-content/uploads/2011/01/become-more-active.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(R.color.blue, "http://www.lakecitysc.com/images/uploads/gallery/arts.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(R.color.cyan,
                                "http://blog.twobrightlights.com/wp-content/uploads/2013/10/48982/Pauley__Whimsey_Photography_by_Cana_176112_Pauley58.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(R.color.red, "http://notjustwines.com.au/wp-content/uploads/2013/06/food-and-wine2.jpg");
                    case 4:
                        return HeaderDesign.fromColorResAndUrl(R.color.green,
                                "http://www.crowneplazasurfersparadise.com.au/wp-content/uploads/2013/04/Skyline-04.jpg");
                    case 5:
                        return HeaderDesign.fromColorResAndUrl(R.color.blue,
                                "http://cdn02.masterstudies.com/element_db/52/5261_Electronics_Music_Production_pic_1.jpg");
                    case 6:
                        return HeaderDesign.fromColorResAndUrl(R.color.cyan,
                                "http://media.supercheapauto.com.au/sca/images/articles/Coolangatta%20Surf_crop.jpg");
                    case 7:
                        return HeaderDesign.fromColorResAndUrl(R.color.red, "http://www.markgray.com.au/images/gallery/large/desert-light.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, DetailActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override public void showEvents(EventResponse eventResponse) {
    }

    @Override public void showError(Throwable throwable) {
    }
}
