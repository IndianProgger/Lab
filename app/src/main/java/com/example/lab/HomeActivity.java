package com.example.lab;

import android.app.ListActivity;
import android.os.Bundle;

public class HomeActivity extends ListActivity {

    static String twenty(int t2,String res){
        int tt1=t2/10;
        switch (tt1) {
            case 2:
                res = res + "двадцать ";
                break;
            case 3:
                res = res + "тридцать ";
                break;
            case 4:
                res = res + "сорок ";
                break;
            case 5:
                res = res + "пятьдесят ";
                break;
            case 6:
                res = res + "шестьдесят ";
                break;
            case 7:
                res = res + "семьдесят ";
                break;
            case 8:
                res = res + "восемьдесят ";
                break;
            case 9:
                res = res + "девяносто ";
                break;
        }

        return res;
    }


    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[1000000];
        String[] dec = {" ","один","два","три","четыре","пять","шесть","семь","восемь","девять","десять",
                "одиннадцать","двенадцать", "тринадцать", "четырнадцать","пятнадцать","шестнадцать",
                "семнадцать","восемнадцать","девятнадцать"};
        String[] hund ={" ","сто","двести","тристо","четыресто","пятьсот","шестьсот","семьсот","восемьсот","девятьсот"};
        String[] hund_dec ={"тысяч ","одна тысяча ","две тысячи ","три тысячи ","четыре тысячи ","пять тысяч ","шесть тысяч ","семь тысяч ","восемь тысяч ","девять тысяч "};

        for (int i = 1; i<1000000; i=i+1){
            String res=" ";
            int t1 = i%1000;
            if (i>=1000){
                int t2 = i/1000;
                if (t2>=100) {
                    int tt1 = t2 / 100;
                    res = res + hund[tt1] + " ";
                }
                t2=t2%100;
                if (t2<1){res=res+" тысяч ";}
                if (t2>=20){
                    res=twenty(t2,res);
                    t2=t2%10;
                    res=res+hund_dec[t2];
                    }
                    else{
                        if(t2>9){
                        res=res+dec[t2]+" тысяч ";
                        }else {
                            res=res+hund_dec[t2];
                        }
                }
            }
            if (t1>=100) {
                int tt1 = t1 / 100;
                res = res + hund[tt1] + " ";
            }
            t1=t1%100;
            if (t1>=20){
                res=twenty(t1,res);
                t1=t1%10;
                res=res+dec[t1];
            } else {
                res=res+dec[t1];
            }

            values[i-1]=res;
        }
        values[999999]="миллион";
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
        setListAdapter(adapter);
    }

  

}
