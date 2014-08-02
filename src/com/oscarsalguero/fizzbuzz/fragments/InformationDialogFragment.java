package com.oscarsalguero.fizzbuzz.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * 
 * A Dialog Fragment used to display an information message when an item on the list is clicked by the user.
 * 
 * @author Oscar Salguero <info@realactionsoft.com>
 * @version 2014.0730
 * @since 1.0
 */
public class InformationDialogFragment extends DialogFragment {

	public static InformationDialogFragment newInstance(int title,
			String message) {
		InformationDialogFragment dialogFragment = new InformationDialogFragment();
		Bundle args = new Bundle();
		args.putInt("title", title);
		args.putString("message", message);
		dialogFragment.setArguments(args);
		return dialogFragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		int title = getArguments().getInt("title");
		String message = getArguments().getString("message");

		return new AlertDialog.Builder(getActivity())
				.setTitle(title)
				.setMessage(message)
				.setNegativeButton("Close",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								onCancel(dialog);
							}
						}).create();
	}

}
