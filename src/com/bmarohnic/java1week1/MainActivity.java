/*
 * project		Java1Week1
 * 
 * package		com.bmarohnic.java1week1
 * 
 * @author		Brent Marohnic
 * 
 * date			Aug 8, 2013
 */
package com.bmarohnic.java1week1;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	LinearLayout ll;
	
	LinearLayout.LayoutParams lp;
	
	EditText et;
	
	TextView result;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        TextView tv = new TextView(this);
        tv.setText(getString(R.string.new_resource_string));
        
        ll.addView(tv);
        
        et = new EditText(this);
        et.setHint("How many children do you have?");
        ll.addView(et);
        
        Button b = new Button(this);
        b.setText("Calculate");
        ll.addView(b);
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Declare all of the variable used in the logic of this event
				float tuitionTotal = 0.0f;
				boolean isItZero = true;
				String errorString = "Please enter a number greater than zero!";
				
				// Is the string equal to null?
				if(et.getText().toString() != null && !et.getText().toString().isEmpty())
				{
					int numberOfChildren = Integer.parseInt(et.getText().toString());
					if(numberOfChildren > 0) isItZero = false;
					
					if(isItZero){
						result.setText(errorString);
					}
					else{
						for(int i=0; i<numberOfChildren; i++){
							tuitionTotal = tuitionTotal + 5000;
						}
						result.setText("College will cost you: " + tuitionTotal);
					}
				}
			}
		});
        
        
        result = new TextView(this);
        ll.addView(result);
        
        setContentView(ll);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
