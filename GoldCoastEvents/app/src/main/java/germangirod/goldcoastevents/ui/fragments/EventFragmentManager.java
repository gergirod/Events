package germangirod.goldcoastevents.ui.fragments;

import android.content.Intent;
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
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.EventResponse;
import germangirod.goldcoastevents.data.presenter.EventsData;
import germangirod.goldcoastevents.data.presenter.EventsPresenter;
import germangirod.goldcoastevents.ui.DetailActivity;
import germangirod.goldcoastevents.ui.adapters.EventsAdapter;

/**
 * Created by germangirod on 5/6/16.
 */
public abstract class EventFragmentManager extends Fragment implements EventsPresenter, EventsAdapter.RowClick {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar progressBar;
    public EventsData eventsData;
    private EventResponse eventResponse;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        return  view;
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

    public void getEventData(){
        eventsData = new EventsData();
        eventsData.setView(this);
    }


    @Override public void showEvents(EventResponse eventResponse) {
        this.eventResponse = eventResponse;
        progressBar.setVisibility(View.GONE);
        EventsAdapter eventsAdapter = new EventsAdapter(this.eventResponse.getEvents(), getActivity());
        eventsAdapter.setRowClick(this);
        mAdapter = new RecyclerViewMaterialAdapter(eventsAdapter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override public void showError(Throwable throwable) {
        progressBar.setVisibility(View.GONE);

    }

    @Override public void onRowClick(View v, int position) {

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("event",this.eventResponse.getEvents().get(position));
        getActivity().startActivity(intent);

    }
}
