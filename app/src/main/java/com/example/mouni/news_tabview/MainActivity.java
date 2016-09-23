package com.example.mouni.news_tabview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mouni.news_tabview.CardAdapters.CardAdapter;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter1;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter2;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter3;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter4;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter5;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter7;
import com.example.mouni.news_tabview.CardAdapters.Youtube_Adapter;
import com.example.mouni.news_tabview.Model.Student;
import com.example.mouni.news_tabview.ObjectClasses.Object11;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    static RestClient restClient;
    private  static ArrayList<Object11> object11ArrayList;
    private static ArrayList<Object11> object12ArrayList;
    private static ArrayList<Object11> object13ArrayList;
    private static ArrayList<Object11> object14ArrayList;
    private static ArrayList<Object11> object15ArrayList;
    private static ArrayList<Object11> object18ArrayList;
    private static ArrayList<Object11> object19ArrayList;
    private static ArrayList<Object11> object20ArrayList;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    //Creating Views
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        restClient =new RestClient();
        object11ArrayList=new ArrayList<>();
        object12ArrayList=new ArrayList<>();
        object13ArrayList=new ArrayList<>();
        object14ArrayList=new ArrayList<>();
        object15ArrayList=new ArrayList<>();
        object18ArrayList=new ArrayList<>();
        object19ArrayList=new ArrayList<>();
        object20ArrayList=new ArrayList<>();


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
           // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            Log.d("mouni","oncreateview");
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));



            if(getArguments().getInt(ARG_SECTION_NUMBER)==1)
            {
                restClient.getService().getObject11(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result="";
                        for(int i=0;i<student.info.size();i++) {
                            Object11 object11=new Object11();
                            object11.setTitle(student.info.get(i).title);
                            object11.setContent(student.info.get(i).content);
                            object11.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni",""+object11ArrayList.add(object11));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        adapter = new CardAdapter(object11ArrayList, inflater.getContext());

                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
            {
                restClient.getService().getObject12(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result="";
                        for(int i=0;i<student.info.size();i++) {
                            Object11 object12=new Object11();
                            object12.setTitle(student.info.get(i).title);
                            object12.setContent(student.info.get(i).content);
                            object12.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni",""+object12ArrayList.add(object12));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        adapter = new CardAdapter1(object12ArrayList, inflater.getContext());

                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }


            else if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {
                restClient.getService().getObject13(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result = "";
                        for (int i = 0; i < student.info.size(); i++) {
                            Object11 object13 = new Object11();
                            object13.setTitle(student.info.get(i).title);
                            object13.setContent(student.info.get(i).content);
                            object13.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni", "" + object13ArrayList.add(object13));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        adapter = new CardAdapter2(object13ArrayList, inflater.getContext());

                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==4) {
                restClient.getService().getObject14(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result = "";
                        for (int i = 0; i < student.info.size(); i++) {
                            Object11 object14 = new Object11();
                            object14.setTitle(student.info.get(i).title);
                            object14.setContent(student.info.get(i).content);
                            object14.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni", "" + object14ArrayList.add(object14));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        adapter = new CardAdapter3(object14ArrayList, inflater.getContext());

                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
                else if(getArguments().getInt(ARG_SECTION_NUMBER)==5) {
                    restClient.getService().getObject15(new Callback<Student>() {
                        @Override
                        public void success(Student student, Response response) {
                            String result = "";
                            for (int i = 0; i < student.info.size(); i++) {
                                Object11 object15 = new Object11();
                                object15.setTitle(student.info.get(i).title);
                                object15.setContent(student.info.get(i).content);
                                object15.setImageUrl(student.info.get(i).thumb);

                                Log.d("mouni", "" + object15ArrayList.add(object15));
                            }

//Initializing Views
                            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                            recyclerView.setHasFixedSize(true);
                            //gridlayout
                            GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                            recyclerView.setLayoutManager(mGridLayoutManager);
                            //Finally initializing our adapter
                            adapter = new CardAdapter4(object15ArrayList, inflater.getContext());

                            //Adding adapter to recyclerview
                            recyclerView.setAdapter(adapter);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }

            else if(getArguments().getInt(ARG_SECTION_NUMBER)==6) {
                restClient.getService().getObject18(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result = "";
                        for (int i = 0; i < student.info.size(); i++) {
                            Object11 object18 = new Object11();
                            object18.setTitle(student.info.get(i).title);
                            object18.setContent(student.info.get(i).content);
                            object18.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni", "" + object18ArrayList.add(object18));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        adapter = new CardAdapter5(object18ArrayList, inflater.getContext());

                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            //Youtube block
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==7) {
                restClient.getService().getObject19(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result = "";
                        for (int i = 0; i < student.info.size(); i++) {
                            Object11 object19 = new Object11();
                            object19.setTitle(student.info.get(i).title);
                            object19.setContent(student.info.get(i).content);
                            object19.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni", "" + object19ArrayList.add(object19));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        //adapter = new CardAdapter6(object19ArrayList, inflater.getContext());
                          adapter=new Youtube_Adapter(getContext());
                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==8) {
                restClient.getService().getObject20(new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        String result = "";
                        for (int i = 0; i < student.info.size(); i++) {
                            Object11 object20 = new Object11();
                            object20.setTitle(student.info.get(i).title);
                            object20.setContent(student.info.get(i).content);
                            object20.setImageUrl(student.info.get(i).thumb);

                            Log.d("mouni", "" + object20ArrayList.add(object20));
                        }

//Initializing Views
                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        //gridlayout
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 2); // (Context context, int spanCount)

                        recyclerView.setLayoutManager(mGridLayoutManager);
                        //Finally initializing our adapter
                        adapter = new CardAdapter7(object20ArrayList, inflater.getContext());

                        //Adding adapter to recyclerview
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(inflater.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
                case 5:
                    return "SECTION 6";
                case 6:
                    return "SECTION 7";
                case 7:
                    return "SECTION 8";

            }
            return null;
        }
    }




}




