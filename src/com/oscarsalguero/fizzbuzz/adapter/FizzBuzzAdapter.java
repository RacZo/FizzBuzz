package com.oscarsalguero.fizzbuzz.adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oscarsalguero.fizzbuzz.R;
import com.oscarsalguero.fizzbuzz.model.FizzBuzzEntry;

/**
 * 
 * An ArrayAdapter used to display the output of Fizz Buzz on a ListFragment.
 * It uses the View Holder pattern to reuse views and improve performance.
 * 
 * <p>
 * This class has a number of Android resource dependencies:
 * <ul>
 * <li>layout/row_output.xml</li>
 * </ul>
 * </p>
 * 
 * @author Oscar Salguero <info@realactionsoft.com>
 * @version 2014.0730
 * @since 1.0
 */
public class FizzBuzzAdapter extends ArrayAdapter<FizzBuzzEntry> {

	static class ViewHolder {
		TextView outputLabel;

		public ViewHolder(View view) {
			this.outputLabel = (TextView) view
					.findViewById(R.id.text_view_label);
		}
	}

	private List<FizzBuzzEntry> list;
	private final Activity activity;

	public FizzBuzzAdapter(Activity activity, List<FizzBuzzEntry> list) {
		super(activity, R.layout.row_output, R.id.text_view_label, list);
		this.activity = activity;
		this.list = list;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = activity.getLayoutInflater();
			view = inflator.inflate(R.layout.row_output, null);
			final ViewHolder viewHolder = new ViewHolder(view);
			view.setTag(viewHolder);
		} else {
			view = convertView;
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.outputLabel.setText(list.get(position).getOutput());
		return view;
	}

}