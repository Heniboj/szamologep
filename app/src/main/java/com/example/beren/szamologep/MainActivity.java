package com.example.beren.szamologep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements OnClickListener{



    TextView szam1;
    TextView szam2;
    TextView eredmeny;
    Button osszead;
    Button kivon;
    Button szoroz;
    Button oszt;
    Button binarybutton;
    Button decimalbutton;

    double sz1;
    double sz2;
    double ered;

    public enum szamrendszerek{decimal,binary}
    szamrendszerek szamrendszer= szamrendszerek.decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        osszead=findViewById(R.id.osszead);
        kivon=findViewById(R.id.kivon);
        szoroz=findViewById(R.id.szoroz);
        oszt=findViewById(R.id.oszt);
        binarybutton=findViewById(R.id.binarybutton);
        decimalbutton=findViewById(R.id.decimalbutton);


        szam1=findViewById(R.id.szam1);
        szam2=findViewById(R.id.szam2);
        eredmeny=findViewById(R.id.eredmeny);
        osszead.setOnClickListener(this);
        kivon.setOnClickListener(this);
        oszt.setOnClickListener(this);
        szoroz.setOnClickListener(this);
        binarybutton.setOnClickListener(this);
        decimalbutton.setOnClickListener(this);


    }




    public void onClick(View v){

        DecimalFormat df = new DecimalFormat("###,###,###,###.###############");
        sz1=Double.parseDouble(szam1.getText().toString());
        sz2=Double.parseDouble(szam2.getText().toString());

        switch(v.getId()){ case R.id.decimalbutton:szamrendszer=szamrendszerek.decimal;szam1.setText("");szam2.setText(""); eredmeny.setText("");  break;
            case R.id.binarybutton:szamrendszer=szamrendszerek.binary;szam1.setText("");szam2.setText(""); eredmeny.setText("");break;
        }




      switch(szamrendszer){


          case decimal:

          switch (v.getId()) {

          case (R.id.osszead):
              ered = sz1 + sz2;
              eredmeny.setText(Double.toString(ered));
              break;

          case (R.id.kivon):
              ered = sz1 - sz2;
              eredmeny.setText(Double.toString(ered));
              break;

          case (R.id.szoroz):
              ered = sz1 * sz2;
              eredmeny.setText(Double.toString(ered));
              break;

          case (R.id.oszt):
              ered = sz1 / sz2;
              eredmeny.setText(Double.toString(ered));
              break;


      }break;

          case binary:
              sz1=0; sz2=0;
              char[] sz1R= szam1.getText().toString().toCharArray();
              char[] sz2R=szam2.getText().toString().toCharArray();
                int i =sz1R.length;
                while (i>0){if(sz1R[i-1]=='1'){sz1=sz1+Math.pow(2,sz1R.length-i);}i--;}
               i =sz2R.length;
              while (i>0){if(sz2R[i-1]=='1'){sz2=sz2+Math.pow(2,sz2R.length-i);}i--;}

              switch(v.getId()){

                  case (R.id.osszead):
                      ered = sz1 + sz2;
                      ered=convert((int)ered);
                      eredmeny.setText(Double.toString(ered));
                      break;

                  case (R.id.kivon):
                      ered = sz1 - sz2;
                      eredmeny.setText(Double.toString(ered));
                      break;

                  case (R.id.szoroz):
                      ered = sz1 * sz2;
                      eredmeny.setText(Double.toString(ered));
                      break;

                  case (R.id.oszt):
                      ered = sz1 / sz2;
                      eredmeny.setText(Double.toString(ered));
                      break;



              }


              break;


      }














        }



public double convert(int convertible){

        String szam="";
        while (convertible>0){szam=szam+convertible%2;convertible=convertible/2;}


        return(Double.parseDouble(new StringBuilder(szam).reverse().toString()));

}



    }




