package dev_pc.recyclerviewsqlite.ui.fragments.birthdayFragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev_pc.recyclerviewsqlite.models.AdapterBirthday;
import dev_pc.recyclerviewsqlite.R;
import dev_pc.recyclerviewsqlite.ui.fragments.birthdayFragment.ItemFragment.OnListFragmentInteractionListener;

import java.util.List;

public class MybirthdayRecyclerViewAdapter extends RecyclerView.Adapter<MybirthdayRecyclerViewAdapter.ViewHolder> {

    private final List<AdapterBirthday> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MybirthdayRecyclerViewAdapter(List<AdapterBirthday> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_birthday, parent, false);
        Log.d("TAG", Integer.toString(mValues.size()));
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        holder.mContentView.setText(mValues.get(position).getData());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction1(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public AdapterBirthday mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.name_b);
            mContentView = (TextView) view.findViewById(R.id.data_b);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
