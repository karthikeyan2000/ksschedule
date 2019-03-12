package in.skylifetech.ks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {
    ArrayList<Schedule> schedules;
    Context mContext;

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        TextView eventVenue;
        TextView eventTime;
        ImageView clusterIcon;

        ScheduleViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventVenue = itemView.findViewById(R.id.eventVenue);
            eventTime = itemView.findViewById(R.id.eventTime);
            clusterIcon = itemView.findViewById(R.id.clusterIcon);
        }
    }

    public ScheduleAdapter(Context mContext, ArrayList<Schedule> schedules) {
        this.schedules = schedules;
        this.mContext = mContext;
    }

    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ScheduleViewHolder scheduleViewHolder = new ScheduleViewHolder(view);
        return scheduleViewHolder;
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, final int listPosition) {
        Schedule schedule = schedules.get(listPosition);
        holder.eventName.setText(schedule.getEventName());
        holder.eventVenue.setText(schedule.getEventVenue());
        holder.eventTime.setText(schedule.getEventTime());
        if (schedule.getClusterIcon() != 0)
            holder.clusterIcon.setBackgroundColor(schedule.getClusterIcon());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

}
