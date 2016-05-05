package germangirod.goldcoastevents.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.Event;
import java.util.List;

/**
 * Created by germangirod on 4/15/16.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventRowHolder> {

    List<Event> events;
    Context context;
    private RowClick rowClick;

    public EventsAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override public int getItemCount() {
        return events.size();
    }

    @Override public EventRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_small, parent, false);

        EventRowHolder eventRowHolder = new EventRowHolder(view);

        return eventRowHolder;
    }

    @Override public void onBindViewHolder(EventRowHolder holder, int position) {

        Picasso.with((context)).load(events.get(position).getEventImageUrl()).into(holder.eventImage);
        holder.eventDate.setText(events.get(position).getEventDate());
        holder.eventName.setText(events.get(position).getEventTitle());
        holder.eventDescription.setText(events.get(position).getEventDescription());
    }

    public void setRowClick(RowClick rowClick) {
        this.rowClick = rowClick;
    }

    public interface RowClick {

        void onRowClick(View v, int position);
    }

    public class EventRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView eventImage;
        TextView eventName;
        TextView eventDate;
        TextView eventDescription;

        public EventRowHolder(View itemView) {
            super(itemView);
            eventImage = (ImageView) itemView.findViewById(R.id.event_image);
            eventName = (TextView) itemView.findViewById(R.id.event_name);
            eventDate = (TextView) itemView.findViewById(R.id.event_date);
            eventDescription = (TextView) itemView.findViewById(R.id.event_description);
            itemView.setOnClickListener(this);
        }

        @Override public void onClick(View v) {

            rowClick.onRowClick(v, getPosition());
        }
    }
}
