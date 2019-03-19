package in.skylifetech.ks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {
    ArrayList<Schedule> schedules = new ArrayList<>();
    Context mContext;

    public ScheduleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_card, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, final int listPosition) {
        Schedule schedule = schedules.get(listPosition);
        holder.setDetails(schedule);
    }

    @Override
    public int getItemCount() {
        if (schedules != null)
            return schedules.size();
        else
            return 0;
    }

    public void setSchedule(ArrayList<Schedule> scheduleArrayList) {
        this.schedules = scheduleArrayList;
    }

    public void addSchedule(Schedule schedule) {
        if (schedules != null)
            schedules.add(schedule);
    }

    public void setData(ArrayList<Schedule> data) {
        this.schedules = data;
        notifyDataSetChanged();
    }

    public int numberOfSchedule() {
        if (schedules != null)
            return schedules.size() - 1;
        else return 0;
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        TextView eventVenue;
        TextView eventTime;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventVenue = itemView.findViewById(R.id.eventVenue);
            eventTime = itemView.findViewById(R.id.eventTime);
        }

        public void setDetails(Schedule schedule) {
            eventName.setText(schedule.getEventName());
            eventVenue.setText(schedule.getEventVenue());
            eventTime.setText(schedule.getEventTime());
        }
    }
}
