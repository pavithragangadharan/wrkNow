package com.example.pr;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {


    Button b1,b2,b3,b4;

    EditText e1;
    ImageButton help;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.miller);
        b4=findViewById(R.id.wilson);
        e1=findViewById(R.id.t1);
        help=findViewById(R.id.help);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int p=Integer.parseInt(e1.getText().toString());

                String s2=("\nWilson Method\n");
                String s1=("For a given Number \"p\"."+"\nFind (p-1)!"+"\nif (p-1)! mod p = 0"+"\n   then P is NOT PRIME\nelse\n   p is PRIME\n");
                long h=fact(p>>1);
                if (p == 4)
                {
                    s1=s1+("ANSWER:\n");
                    s1=s1+(p+" is NOT PRIME.");
                }
                long k=h % p;
                if(k==0)
                {
                    s1=s1+("\nANSWER:\n");
                    s1=s1+("("+(p-1)+")! ="+h+"\n"+h+" mod "+p+" = "+k+"\n");
                    s1=s1+(p+" is NOT PRIME.");

                }
                else
                {
                    s1=s1+("\nANSWER:\n");
                    s1=s1+("("+(p-1)+")! ="+h+"\n"+h+" mod "+p+" = "+k+"\n");
                    s1=s1+(p+" is PRIME.");
                }
                Intent i =new Intent(MainActivity.this,next.class);
                i.putExtra("s1",s1);
                i.putExtra("s2",s2);

                startActivity(i);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,help.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n=Integer.parseInt(e1.getText().toString());
                int k=3;
                String s1=null;
                String s2=("\nFermat Method\n");
                s1=("\nFor a given Number \"p\".\n");
                s1=s1+("Select a random number \"a\".\nSuch that 1<a<p.\n");
                s1=s1+("If (a^(p-1) mod p = 1): \n");
                s1=s1+("  then either \"p\" is prime or \"a\" is Fermat liar.\n");
                s1=s1+("Else:\n");
                s1=s1+("  then \"p\" is not prime.\n");
                int check=1;
                if (n <= 1 || n == 4) check=0;
                if (n <= 3) check=1;
                int a = 2 + (int)Math.random();
                int x=mod(a, n - 1, n);
                while (k > 0)
                {
                    if ( x!= 1)
                    {

                        check=0;
                        break;
                    }

                    k--;
                }

                if (check==0)
                {
                    s1=s1+("\nANSWER:\n");
                    s1=s1+(a+"^("+n+"-1) mod "+n+" = "+x+".\n");
                    s1=s1+("Thus "+n+" is NOT Prime.\n");
                }

                if(check==1)
                {
                    s1=s1+("\nANSWER:\n");
                    s1=s1+(a+"^("+n+"-1) mod "+n+" = 1."+"\n\nThus "+n+" may be Prime.\n");
                }

                Intent i =new Intent(MainActivity.this,next.class);
                i.putExtra("s1",s1);
                i.putExtra("s2",s2);

                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n=Integer.parseInt(e1.getText().toString());

                String s1=null ;

                String s2=("\nTraditional method\n");

                int check=0;
                for (int i = 2; i < Math.sqrt(n); i++)
                {
                    if (n % i == 0)
                    {
                        check=1;
                        s1=("\n"+n+" is divisible by "+i+".\n");
                        break;
                    }
                }
                if (check==1)
                  s1=s1+("\nANSWER:\nThus "+n+" is NOT Prime.\n");

                if(check==0)
                  s1=("\n"+n+" is divisible only by 1 and itself.\n\nANSWER:\nThus "+n+" is Prime.\n");

                Intent i =new Intent(MainActivity.this,next.class);
                i.putExtra("s1",s1);
                i.putExtra("s2",s2);

                startActivity(i);


            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = ("\nMiller_Rabin Method\n");
                String s1 = ("For a given Number \"p\"." + "\nSelect a random number \"a\".\nSuch that 1<a<p." + "\nNow represent p-1 as 2^s.d" + "\nCompute k=a^(2^r).d \nfor all  0 ≤\"r\" ≤ s − 1\n" + "if (k mod p equals to 1 or p-1):\n" + "   then either p is prime or\n \"a\" is a Strong Liar.\n" + "else:\n" + "   p is not prime.\n" + "\n");
                int n = Integer.parseInt(e1.getText().toString());

                int d = n - 1;

                while (d % 2 == 0)
                    d /= 2;
                if (!s_d(d, n)) {
                    s1 = s1 + ("ANSWER:\n");
                    //System.out.println(a+"^("+n+"-1) mod "+n+" = "+x+".");
                    s1 = s1 + (n + " is NOT PRIME.");
                } else {
                    s1 = s1 + ("ANSWER:\n");
                    //System.out.println(a+"^("+n+"-1) mod "+n+" = 1."+"\nThus "+n+" may be Prime.");
                    s1 = s1 + (n + " MAY BE PRIME ");
                }

                Intent i =new Intent(MainActivity.this,next.class);
                i.putExtra("s1",s1);
                i.putExtra("s2",s2);
                startActivity(i);

            }



        });

    }
    public static int mod(int a,int n, int p)
    {
        int result = 1;
        a = a % p;
        while (n > 0)
        {
            if ((n & 1) == 1)
                result = (result * a) % p;
            n = n >> 1; // n = n/2
            a = (a * a) % p;
        }
        return result;
    }
    static int power(int x, int y, int p) {

        int res = 1;
        x = x % p;

        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }
        public static boolean s_d(int d, int n) {
        int a = 2 + (int)(Math.random() % (n - 4));
        int x = power(a, d, n);

        if (x == 1 || x == n - 1)
            return true;
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }
        return false;
    }
    public static long fact(int p)
    {
        if (p <= 1)
            return 1;
        return p * fact(p - 1);
    }

}
