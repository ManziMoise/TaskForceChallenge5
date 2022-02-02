package com.example.taskforcechallenge50;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskforcechallenge50.Domain.Task;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Task> taskList;
    private ArrayList<Task> activity;

    public Adapter(ArrayList<Task> mainActivity){
        this.taskList = taskList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View SingleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row_layout, null);
        return new ViewHolder(SingleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int check = 0;
        Task taskItem = taskList.get(position);
        holder.checkTask.setText(taskItem.getTitle());
//        holder.prioritytv.setText(taskItem.getMode());
        holder.checkTask.setChecked(toBoolean(check));

    }

    private boolean toBoolean(int x){
        return x!=0;
    }

    public void setTasks(List<Task> listTask){
        this.taskList = (ArrayList<Task>) listTask;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkTask;
        TextView titletv, prioritytv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkTask = itemView.findViewById(R.id.checkbox);
            titletv = itemView.findViewById(R.id.title);
            prioritytv = itemView.findViewById(R.id.priorityText);
        }
    }
}
