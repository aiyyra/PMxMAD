package com.example.westudy;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.Objects;

public class AppointmentNoteListAdapter extends ListAdapter<AppointmentNote, AppointmentNoteViewHolder> {

    public AppointmentNoteListAdapter(@NonNull DiffUtil.ItemCallback<AppointmentNote> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public AppointmentNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AppointmentNoteViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(AppointmentNoteViewHolder holder, int position) {
        AppointmentNote current = getItem(position);
        holder.bind(current.getmDate(), current.getmCourse(), current.getmSlot());
    }

    static class NoteDiff extends DiffUtil.ItemCallback<AppointmentNote> {

        @Override
        public boolean areItemsTheSame(@NonNull AppointmentNote oldItem, @NonNull AppointmentNote newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AppointmentNote oldItem, @NonNull AppointmentNote newItem) {
            return Objects.equals(oldItem.getmSlot(), newItem.getmSlot());
        }
    }
}
