package com.oscarsalguero.fizzbuzz.fragments;

import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.oscarsalguero.fizzbuzz.R;
import com.oscarsalguero.fizzbuzz.adapter.FizzBuzzAdapter;
import com.oscarsalguero.fizzbuzz.model.FizzBuzzEntry;

/**
 * A ListFragment used to display the Fizz Buzz output
 * 
 * @author Oscar Salguero <info@realactionsoft.com>
 * @version 2014.0730
 * @since 1.0
 */
public class FizzBuzzListFragment extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);

		int start = 1;
		int end = 15;
		
		List<FizzBuzzEntry> output = getFizzBuzzOutput(start, end);

		FizzBuzzAdapter adapter = new FizzBuzzAdapter(getActivity(), output);

		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		InformationDialogFragment dialogFragment = InformationDialogFragment
				.newInstance(
						R.string.dialog_title_information,
						"You clicked on: "
								+ ((FizzBuzzEntry) listView
										.getItemAtPosition(position))
										.getOutput());
		dialogFragment.show(getFragmentManager(), "information_dialog");
	}

	/**
	 * Method that returns a list with the Fizz Buzz solution
	 * 
	 * @param start An integer specifying where to start
	 * @param end An integer specifying where to end
	 * @return A List with the resulting Fizz Buzz output
	 */
	private List<FizzBuzzEntry> getFizzBuzzOutput(int start, int end) {

		List<FizzBuzzEntry> output = new LinkedList<FizzBuzzEntry>();
		
		/*
		 * I used a LinkedList to ensure the Fizz Buzz output is going to keep
		 * its original order
		 */

		for (int i = start; i <= end; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				
				/*
				if (i % 3 == 0 && i % 5 == 0) {
					output.add(new FizzBuzzEntry(Integer.toString(i), "Fizz Buzz"));
				}
				*/
				
				/* 
				 * The if above "if" not on the solution I was given but the traditional 
				 * FizzBuzz problem tells you to show Fizz Buzz if the number is mod 3 and mod 5
				 */
				
				if (i % 3 == 0) {
					output.add(new FizzBuzzEntry(Integer.toString(i), "Fizz"));
				}
				if (i % 5 == 0) {
					output.add(new FizzBuzzEntry(Integer.toString(i), "Buzz"));
				}
				
			} else {
				output.add(new FizzBuzzEntry(Integer.toString(i), Integer
						.toString(i)));
			}
		}
		return output;
	}
}
