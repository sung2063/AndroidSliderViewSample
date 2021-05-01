package com.sung2063.slideshowviewsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sung2063.slideshowviewsample.R;
import com.sung2063.slideshowviewsample.model.MainOptionModel;

import java.util.List;

public class MenuOptionRecyclerViewAdapter extends RecyclerView.Adapter<MenuOptionRecyclerViewAdapter.ViewHolder> {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private Context context;
    private List<MainOptionModel> object;
    private LayoutInflater layoutInflater;
    private MenuOptionListener menuOptionListener;

    // =============================================================================================
    // Constructor
    // =============================================================================================
    public MenuOptionRecyclerViewAdapter(Context context, List<MainOptionModel> object) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.object = object;
    }

    // =============================================================================================
    // Methods
    // =============================================================================================
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.menu_option_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainOptionModel mainOptionData = object.get(position);
        int backgroundId = mainOptionData.getBackgroundId();
        if (backgroundId != -1) {
            holder.clContainer.setBackgroundColor(backgroundId);
        }
        holder.ivIcon.setImageResource(mainOptionData.getIconId());
        DrawableCompat.setTint(holder.ivIcon.getDrawable(), ContextCompat.getColor(context, mainOptionData.getIconColor()));
        holder.tvTitle.setText(mainOptionData.getTitle());
        holder.tvTitle.setTextColor(mainOptionData.getTextColorId());
        holder.tvDescription.setText(mainOptionData.getDescription());
        holder.tvDescription.setTextColor(mainOptionData.getTextColorId());
    }

    @Override
    public int getItemCount() {
        return object.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ConstraintLayout clContainer;
        private ImageView ivIcon;
        private TextView tvTitle, tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            clContainer = itemView.findViewById(R.id.cl_container);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (menuOptionListener != null) {
                menuOptionListener.onMenuClicked(getAdapterPosition());
            }
        }
    }

    public void setListener(MenuOptionListener listener) {
        this.menuOptionListener = listener;
    }

    public interface MenuOptionListener {
        void onMenuClicked(int position);
    }
}
