package com.rareventure.gps2.reviewer;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.rareventure.gps2.R;

public class PasswordDialogFragment extends DialogFragment {
	
	
	private String message;
	public String title;


	public static class Builder {

		private PasswordDialogFragment pdf;
		private FragmentActivity activity;

		public Builder(FragmentActivity activity) {
			this.activity = activity;
			
			pdf = new PasswordDialogFragment();
			
		}

	    public Builder setOnOk(final OnOkListener onOkListener)
	    {
	    	pdf.onOkListener = onOkListener;
	    	
	    	return this;
	    }

	    public Builder setMessage(String message)
	    {
	    	pdf.message = message;
	    	
	    	return this;
	    }

		public void show() {
		    // Create and show the dialog.
		    pdf.show(activity.getSupportFragmentManager().beginTransaction(), "dialog");		
		}

		public Builder setTitle(String title) {
			pdf.title = title;
			
			return this;
		}
	    
	}

	private OnEditorActionListener onEditorActionListener = new OnEditorActionListener() {
		
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			okButton.performClick();
			return false;
		}
	};
	private View v;

	private Button cancelButton;

	private TextView passwordEditText;

	private TextView messageText;
	private Button okButton;
	private OnOkListener onOkListener;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dialog_enter_password, container, false);

        okButton = ((Button)v.findViewById(R.id.ok_button));
        okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onOkListener.onOk(passwordEditText.getText());
				dismiss();
			}
		});
        
        cancelButton = ((Button)v.findViewById(R.id.cancel_button));
        cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
        
        messageText = ((TextView)v.findViewById(R.id.message));
        messageText.setText(message);
        
        passwordEditText = ((EditText)v.findViewById(R.id.enter_password));

        passwordEditText.setOnEditorActionListener(onEditorActionListener);
        
        getDialog().setTitle(title);
        
        return v;
	}
    
    public void setPassword(String password)
    {
    	passwordEditText.setText(password);
    }
    
    public static interface OnOkListener
    {
