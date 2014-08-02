package com.oscarsalguero.fizzbuzz;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.oscarsalguero.fizzbuzz.fragments.FizzBuzzListFragment;
import com.oscarsalguero.fizzbuzz.fragments.InformationDialogFragment;

/**
 * Main Activity
 * 
 * This activity is used to display the App's user interface.
 * 
 * <p>
 * This class has a number of Android resource dependencies:
 * <ul>
 * <li>layout/activity_main.xml</li>
 * </ul>
 * </p>
 * 
 * @author Oscar Salguero <info@realactionsoft.com>
 * @version 2014.0730
 * @since 1.0
 */
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new FizzBuzzListFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_about) {
			InformationDialogFragment dialogFragment = InformationDialogFragment
					.newInstance(R.string.dialog_title_about, getResources()
							.getString(R.string.dialog_message_about));
			dialogFragment.show(getSupportFragmentManager(), "about_dialog");
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}