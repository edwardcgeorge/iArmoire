package com.eoe.iArmoire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
public class ThumbnailsActivity extends Activity {
	public int result;
    String r;
	private static final String[] yijia={"1���¼�","2���¼�","3���¼�","4���¼�"};   
	private ArrayAdapter<String> adapter11;
	private Spinner spinner11;
	private Button coButton,baButton;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);
    	spinner11 = (Spinner) findViewById(R.id.Spinner11);   
    	adapter11 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,yijia);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter11);
        baButton= (Button)findViewById(R.id.buttonback);
        coButton = (Button) findViewById(R.id.buttonconfirm);  
        
        baButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {  
    	        	Intent intent2=new Intent(ThumbnailsActivity.this,MainActivity.class);
    				ThumbnailsActivity.this.startActivity(intent2);
    	        	} catch (Exception e) {  }  
											}
															});
        coButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {  
    	        	Intent intent2=new Intent(ThumbnailsActivity.this,BTClient.class);
Bundle bundle=new Bundle();
    	            //传�name参数为tinyphp
    	            bundle.putString("num",r);
    	            intent2.putExtras(bundle);
    				ThumbnailsActivity.this.startActivity(intent2);
    	        	Toast.makeText(ThumbnailsActivity.this, "�������ѡ��", Toast.LENGTH_LONG).show();
    	        	} catch (Exception e) { }  
											}
														});
        //����¼�Spinner�¼�����  
        spinner11.setOnItemSelectedListener(new OnItemSelectedListener() {

    			@Override
    			public void onItemSelected(AdapterView<?> arg0, View arg1,
    					int holder, long arg3) {
    				// TODO Auto-generated method stub
    				//view1.setText("�·������ǣ�"+m[holder]);
    				//costumeName1=yijia[holder];
    			result=holder+1;
    			r=Integer.toString(result);									}
    			@Override
    			public void onNothingSelected(AdapterView<?> arg0) {}
    																	});
        
        spinner11.setVisibility(View.VISIBLE);    
       
    }
}