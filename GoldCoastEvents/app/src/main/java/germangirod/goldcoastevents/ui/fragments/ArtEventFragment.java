package germangirod.goldcoastevents.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import germangirod.goldcoastevents.Constants;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.api.EventsApi;
import germangirod.goldcoastevents.data.model.Event;
import germangirod.goldcoastevents.data.model.EventResponse;
import germangirod.goldcoastevents.data.presenter.EventsData;
import germangirod.goldcoastevents.data.presenter.EventsPresenter;
import germangirod.goldcoastevents.ui.adapters.EventsAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by germangirod on 4/15/16.
 */
public class ArtEventFragment extends Fragment implements EventsPresenter {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private EventsApi eventsApi;

    private static final int ITEM_COUNT = 20;

    private List<Event> events = new ArrayList<>();

    public static ArtEventFragment newInstance() {
        return new ArtEventFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);

    }

    @Override public void onResume() {
        super.onResume();
        getEventData();

    }

    private void getEventData(){
        EventsData eventsData = new EventsData();
        eventsData.getEventsByCategory(Constants.ART_CATEGORY);
    }

    @Override public void showEvents(EventResponse eventResponse) {
        mAdapter = new RecyclerViewMaterialAdapter(new EventsAdapter(eventResponse.getEvents(),getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override public void showError(Throwable throwable) {

    }
}
