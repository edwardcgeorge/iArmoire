package com.eoe.iArmoire;

import java.io.File;  
import android.app.Activity;  
import android.content.Intent;  
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;  
import android.os.Bundle;    
import android.view.View;  
import android.widget.ArrayAdapter;
import android.widget.Button;  
import android.widget.ImageView;  
import android.widget.Spinner;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;


public class LabelActivity extends Activity {  
	public ImageView mImageView;  
	public File mPhotoFile;  
	public int hangernumber;
	public String mPhotoPath;
    public final static int CAMERA_RESULT=8888;  
    public final static String TAG="xx";  
    private static final String[] m={"衣服","裤子"}, 
    		mm={"春","夏","秋","冬"},
    		mmm={"1号衣架","2号衣架","3号衣架","4号衣架"};
    String vi,vi1,vi2,vi3,vi4,vi5,costumeName,costumeName1,costumeName2,costumeName3=null;
    Button confirm;
    private TextView view1,view2,view3;//value1;
    private Spinner spinner01,spinner02,spinner03;
    private ArrayAdapter<String> adapter1,adapter2,adapter3;
    @Override  
    public void onCreate(Bundle savecostumeNamenstanceState) {  
        super.onCreate(savecostumeNamenstanceState);  
        setContentView(R.layout.choose_label);   
        mImageView = (ImageView) findViewById(R.id.imageLabel);
        Intent intent = getIntent();  
        //获取传递过来的值  
        mPhotoPath = intent.getStringExtra("value");
        Bitmap bitmap = BitmapFactory.decodeFile(mPhotoPath, null);  
        mImageView.setImageBitmap(bitmap); 
        //value1 = (TextView) findViewById(R.id.spinnerTexttem);
        view1 = (TextView) findViewById(R.id.spinnerText1);
        view2 = (TextView) findViewById(R.id.spinnerText2);
        view3 = (TextView) findViewById(R.id.spinnerText3);
        spinner01 = (Spinner) findViewById(R.id.Spinner01);
        spinner02 = (Spinner) findViewById(R.id.Spinner02);
        spinner03 = (Spinner) findViewById(R.id.Spinner03);
        confirm = (Button) findViewById(R.id.button2);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mm);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mmm);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(adapter1);
        spinner02.setAdapter(adapter2);
        spinner03.setAdapter(adapter3);
         
        //添加事件Spinner事件监听  
        spinner01.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int holder, long arg3) {
				// TODO Auto-generated method stub
				view1.setText("衣服类型是："+m[holder]);
				costumeName1=m[holder];
				switch (holder) {
				case 0:
					vi1="1";
					break;
				case 1: 
					vi1="0";
					break;
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        spinner01.setVisibility(View.VISIBLE);
        spinner02.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int holder, long arg3) {
				// TODO Auto-generated method stub
				view2.setText("适配季节是："+mm[holder]);
				costumeName2=mm[holder];
				switch (holder) {
				case 0:
			
					vi2="00";
					break;
				case 1: 
					vi2="01";
					break;
				case 2:
					vi2="10";
					break;
				case 3:
					vi2="11";
					break;
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        spinner03.setVisibility(View.VISIBLE);
        
        spinner03.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int holder, long arg3) {
				// TODO Auto-generated method stub
				view3.setText("衣架编号是："+mmm[holder]);
				costumeName3=mmm[holder];
				hangernumber=holder;
				switch (holder) {
				case 0:
					vi3="00";
					break;
				case 1: 
					vi3="01";
					break;
				case 2:
					vi3="10";
					break;
				case 3:
					vi3="11";
					break;
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        spinner03.setVisibility(View.VISIBLE);
        
        confirm.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
				
				try{ boolean bool=false;
					//File f;
					//File f1;
					
					vi=vi1+vi2+vi3;
					costumeName=costumeName1+costumeName2+costumeName3;
					File f=new File(mPhotoPath);
					File f1=new File("mnt/sdcard/衣服/"+costumeName+".jpg");
					bool=f.renameTo(f1);
					if(bool){
					Intent intent1=new Intent(LabelActivity.this,MainActivity.class);
					LabelActivity.this.startActivity(intent1);
					//intent1.putExtra("hanger", hangernumber);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
        });
        
    }
   
}

