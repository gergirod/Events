package germangirod.goldcoastevents.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import germangirod.goldcoastevents.Constants;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.EventResponse;
import germangirod.goldcoastevents.data.presenter.EventsData;
import germangirod.goldcoastevents.data.presenter.EventsPresenter;
import germangirod.goldcoastevents.ui.adapters.EventsAdapter;

/**
 * Created by germangirod on 4/15/16.
 */
public class GeneralEventFragment extends Fragment implements EventsPresenter, EventsAdapter.RowClick {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar progressBar;

    public static GeneralEventFragment newInstance() {
        return new GeneralEventFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        return  view;    }

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
        eventsData.setView(this);
        eventsData.getEventsByCategory(Constants.GENERAL_CATEGORY);
    }

    @Override public void showEvents(EventResponse eventResponse) {
        progressBar.setVisibility(View.GONE);
        EventsAdapter eventsAdapter = new EventsAdapter(eventResponse.getEvents(), getActivity());
        eventsAdapter.setRowClick(this);
        mAdapter = new RecyclerViewMaterialAdapter(eventsAdapter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override public void showError(Throwable throwable) {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void onRowClick(View v, int position) {

    }
}
