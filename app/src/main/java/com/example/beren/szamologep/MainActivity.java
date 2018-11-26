package com.example.beren.szamologep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

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
    Button hexabutton;

    double sz1;
    double sz2;
    double ered;

    char[] sz1R;
    char[] sz2R;

    public enum szamrendszerek{decimal,binary,hexa}
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
        hexabutton=findViewById(R.id.hexabutton);


        szam1=findViewById(R.id.szam1);
        szam2=findViewById(R.id.szam2);
        eredmeny=findViewById(R.id.eredmeny);
        osszead.setOnClickListener(this);
        kivon.setOnClickListener(this);
        oszt.setOnClickListener(this);
        szoroz.setOnClickListener(this);
        binarybutton.setOnClickListener(this);
        decimalbutton.setOnClickListener(this);
        hexabutton.setOnClickListener(this);


    }




    public void onClick(View v){

        DecimalFormat df = new DecimalFormat("###,###,###,###.###############");




        switch(v.getId()){ case R.id.decimalbutton:szamrendszer=szamrendszerek.decimal;eredmeny.setText("");  break;
            case R.id.binarybutton:szamrendszer=szamrendszerek.binary;eredmeny.setText("");break;
            case R.id.hexabutton:szamrendszer=szamrendszerek.hexa;eredmeny.setText("");break;
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

               sz1R= szam1.getText().toString().toCharArray();
               sz2R=szam2.getText().toString().toCharArray();
                int i =sz1R.length;
                while (i>0){if(sz1R[i-1]=='1'){sz1=sz1+Math.pow(2,sz1R.length-i);}i--;}
               i =sz2R.length;
              while (i>0){if(sz2R[i-1]=='1'){sz2=sz2+Math.pow(2,sz2R.length-i);}i--;}

              switch(v.getId()){

                  case (R.id.osszead):
                      ered = sz1 + sz2;
                      ered=tobinary((int)ered);
                      eredmeny.setText(Double.toString(ered));
                      break;

                  case (R.id.kivon):
                      ered = sz1 - sz2;
                      ered=tobinary((int)ered);
                      eredmeny.setText(Double.toString(ered));
                      break;

                  case (R.id.szoroz):
                      ered = sz1 * sz2;
                      ered=tobinary((int)ered);
                      eredmeny.setText(Double.toString(ered));
                      break;

                  case (R.id.oszt):
                      ered = sz1 / sz2;
                      ered=tobinary((int)ered);
                      eredmeny.setText(Double.toString(ered));
                      break;





              } break;

          case hexa:

              sz1=0; sz2=0;

               sz1R=szam1.getText().toString().toCharArray();
               sz2R=szam2.getText().toString().toCharArray();

               sz1=fromhexa(sz1R);
               sz2=fromhexa(sz2R);


               switch(v.getId()){

                   case (R.id.osszead):
                       ered = sz1 + sz2;

                       eredmeny.setText(tohexa((int)ered));
                       break;

                   case (R.id.kivon):
                       ered = sz1 - sz2;

                       eredmeny.setText(tohexa((int)ered));
                       break;

                   case (R.id.szoroz):
                       ered = sz1 * sz2;

                       eredmeny.setText(tohexa((int)ered));
                       break;

                   case (R.id.oszt):
                       ered = sz1 / sz2;

                       eredmeny.setText(tohexa((int)ered));
                       break;


               } break;






      }

        }



public double tobinary(int convertible){

        String szam="";
        while (convertible>0){szam=szam+convertible%2;convertible=convertible/2;}

if( szam.isEmpty()==true){  Toast.makeText(this, "Kérem adjon meg megfelelő értéket.", Toast.LENGTH_SHORT).show(); return(0);
    }
    else{
        return(Double.parseDouble(new StringBuilder(szam).reverse().toString()));}





    }
    public double fromhexa(char[] convertible){
double vegsoertek=0;
       int i =convertible.length;
        while (i>0){switch(convertible[i-1]){
            case 'A':  vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*10);i--;
                break;
            case 'B':vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*11);i--;
                break;
            case 'C':vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*12);i--;
                break;
            case 'D':vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*13);i--;
                break;
            case 'E':vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*14);i--;
                break;
            case 'F':vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*15);i--;
                break;

            default: vegsoertek=vegsoertek+(Math.pow(16,convertible.length-i)*Character.getNumericValue(convertible[i-1]));i--;
             break;
        }




   }
return(vegsoertek);

}




public String  tohexa(int convertible){


        String szam="" ;
        while(convertible>0){

            if((convertible%16)>9 && (convertible%16)<16){
                switch(convertible%16){

                    case 10: szam=szam+"A";
                                break;

                    case 11: szam=szam+"B";
                        break;

                    case 12: szam=szam+"C";
                        break;

                    case 13: szam=szam+"D";
                        break;

                    case 14: szam=szam+"E";
                        break;

                    case 15: szam=szam+"F";
                        break; }
                convertible=convertible/16;}

                else{szam=szam+(convertible%16);
                        convertible=convertible/16;
            }


        }



     return(new StringBuilder(szam).reverse().toString());


}


    }




