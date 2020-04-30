package com.example.metodosnumericos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ResultadosActivity extends AppCompatActivity {

    public static final double TOLERANCIA = -1E-3;
    public static int valorExp, valorInde, valorDep, nuevoX1, nuevoX2, nuevoX3, nuevoA, nuevoB, nuevoAproxA, nuevoAproxB;

    public static double a;
    public static double b;
    public static double m;
    public static double mAnterior;
    public static double tol;
    public static double aproxA, aproxB;
    public static double x0, x1;

    TextView atv, btv, mtv, fatv, fbtv, fmtv, fafmtv, errortv, formulatv, xntv, fxntv, fdxntv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        String textoRecibidoA = getIntent().getStringExtra("keyA");
        String textoRecibidoB = getIntent().getStringExtra("keyB");
        String textoRecibidoX1 = getIntent().getStringExtra("keyX1");
        String textoRecibidoX2 = getIntent().getStringExtra("keyX2");
        String textoRecibidoX3 = getIntent().getStringExtra("keyX3");

        String casoRecibido = getIntent().getStringExtra("keyCaso");

        String aproxARecibido = getIntent().getStringExtra("keyAproxA");
        String aproxBRecibido = getIntent().getStringExtra("keyAproxB");

        formulatv = findViewById(R.id.formula);

        atv = findViewById(R.id.textView_resultados_a);
        btv = findViewById(R.id.textView_resultados_b);
        mtv = findViewById(R.id.textView_resultados_m);
        fatv = findViewById(R.id.textView_resultados_fa);
        fbtv = findViewById(R.id.textView_resultados_fb);
        fmtv = findViewById(R.id.textView_resultados_fm);
        fafmtv = findViewById(R.id.textView_resultados_fafm);
        errortv = findViewById(R.id.textView_resultados_error);

        xntv = findViewById(R.id.textView_resultados_xn);
        fxntv = findViewById(R.id.textView_resultados_fxn);
        fdxntv = findViewById(R.id.textView_resultados_fdxn);

        int nuevoCasoRecibido = Integer.parseInt(casoRecibido);

        //int nuevoA = Integer.parseInt(textoRecibidoA);
        //int nuevoB = Integer.parseInt(textoRecibidoB);
        nuevoX1 = Integer.parseInt(textoRecibidoX1);
        nuevoX2 = Integer.parseInt(textoRecibidoX2);
        nuevoX3 = Integer.parseInt(textoRecibidoX3);

        //int nuevoAproxA = Integer.parseInt(aproxARecibido);

        valorExp = nuevoX1;
        valorInde = nuevoX2;
        valorDep = nuevoX3;

        //a = nuevoA;
        //b = nuevoB;
        //aproxA = nuevoAproxA;

        tol = 0;
        mAnterior = 0;

        switch (nuevoCasoRecibido){
            case 1:
                // Esta es la operacion del caso 1, Biseccion con funcion cubica

                nuevoA = Integer.parseInt(textoRecibidoA);
                nuevoB = Integer.parseInt(textoRecibidoB);
                a = nuevoA;
                b = nuevoB;

                bisCalcularFcubica(valorExp,valorInde,valorDep,a,b,tol);
                //String formulaStg = nuevoX1 + "x^3 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^3 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^3 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                //Aqui termina operacion caso 1
                break;

            case 2:
                //Caso 2, biseccion cuadrada

                nuevoA = Integer.parseInt(textoRecibidoA);
                nuevoB = Integer.parseInt(textoRecibidoB);
                a = nuevoA;
                b = nuevoB;

                bisCalcularFcuadrada(valorExp,valorInde,valorDep,a,b,tol);
                //String formulaStg = nuevoX1 + "x^2 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^2 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^2 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^2 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^2 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                break;

            case 3:
                //Caso 3, falsa posicion cubica

                nuevoA = Integer.parseInt(textoRecibidoA);
                nuevoB = Integer.parseInt(textoRecibidoB);
                a = nuevoA;
                b = nuevoB;

                falsaCalcularCubica(valorExp,valorInde,valorDep,a,b,tol);
                //String formulaStg = nuevoX1 + "x^3 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^3 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^3 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                break;

            case 4:
                //Caso 4, falsa posicion cuadrada

                nuevoA = Integer.parseInt(textoRecibidoA);
                nuevoB = Integer.parseInt(textoRecibidoB);
                a = nuevoA;
                b = nuevoB;

                falsaCalcularCuadrada(valorExp,valorInde,valorDep,a,b,tol);
                //String formulaStg = nuevoX1 + "x^2 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^2 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^2 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^2 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^2 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                break;

            case 5:
                //Caso 5, Newton Raphson cubica
                nuevoAproxA = Integer.parseInt(aproxARecibido);
                aproxA = nuevoAproxA;

                newtonCalcularCubica(valorExp,valorInde,valorDep,aproxA,tol);
                //String formulaStg = nuevoX1 + "x^3 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^3 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^3 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                break;

            case 6:
                //Caso 6, Newton Raphson cuadrada
                nuevoAproxA = Integer.parseInt(aproxARecibido);
                aproxA = nuevoAproxA;

                newtonCalcularCuadrada(valorExp,valorInde,valorDep,aproxA,tol);
                //String formulaStg = nuevoX1 + "x^2 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^2 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^2 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^2 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^2 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                break;

            case 7:
                //Caso 7, Secante cubica
                nuevoAproxA = Integer.parseInt(aproxARecibido);
                aproxA = nuevoAproxA;

                nuevoAproxB = Integer.parseInt(aproxBRecibido);
                aproxB = nuevoAproxB;

                secanteCalcularCubica(valorExp,valorInde,valorDep,aproxA, aproxB, tol);
                //String formulaStg = nuevoX1 + "x^3 " + nuevoX2 + "x " + nuevoX3;
                if(nuevoX2 > 0 && nuevoX3 < 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 > 0 && nuevoX3 > 0){
                    String formulaStg = nuevoX1 + "x^3 " + " + " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else
                if(nuevoX2 < 0 && nuevoX3 > 0) {
                    String formulaStg = nuevoX1 + "x^3 " + "+ " + nuevoX2 + "x + " + nuevoX3;
                    formulatv.append(formulaStg);
                } else {
                    String formulaStg = nuevoX1 + "x^3 "  + nuevoX2 + "x " + nuevoX3;
                    formulatv.append(formulaStg);
                }
                break;

            case 8:
                break;

            case 9:
                break;

            case 10:
                break;
        }

    }

    public void bisCalcularFcuadrada(int valorExp, int valorInde, int valorDep, double rangoA, double rangoB, double tolerancia){
        mAnterior = 0;
        m = (a+b)/2;

        System.out.println("Tolerancia de operacion: " + tol
                + "\nTolerancia de resultado: " + TOLERANCIA);
        do {
            System.out.println("a = " + a); atv.append(" " + a + "   ");
            System.out.println("b = " + b); btv.append(" " + b + "   ");
            System.out.println("m = " + m); mtv.append(" " + m + "   ");

            System.out.println("f(a) = " + fCuadrada(a)); fatv.append(" " + fCuadrada(a) + "   ");
            System.out.println("f(b) = " + fCuadrada(b)); fbtv.append(" " + fCuadrada(b) + "   ");
            System.out.println("f(m) = " + fCuadrada(m)); fmtv.append(" " + fCuadrada(m) + "   ");

            System.out.println("f(a)*f(m) = " + fCuadrada(a) * fCuadrada(m)); fafmtv.append(" " + fCuadrada(a)*fCuadrada(m) + "   ");
            if(fCuadrada(a) * fCuadrada(m) > 0){
                a = m;
            } else {
                b = m;
            }

            mAnterior = m;
            m = (a+b)/2;
            tol = Math.abs((m - mAnterior) / m);

            System.out.println("Error o tolerancia = " + tol); errortv.append(" " + tol + "   ");
            System.out.println("Actual: " + tol + "\nEsperada: " + TOLERANCIA + "\n");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));

    }

    public void bisCalcularFcubica(int valorExp, int valorInde, int valorDep, double rangoA, double rangoB, double tolerancia){

        mAnterior = 0;
        m = (a+b)/2;

        System.out.println("Tolerancia de operacion: " + tol
                + "\nTolerancia de resultado: " + TOLERANCIA);
        do {
            System.out.println("a = " + a); atv.append(" " + a + "   ");
            System.out.println("b = " + b); btv.append(" " + b + "   ");
            System.out.println("m = " + m); mtv.append(" " + m + "   ");
            System.out.println("f(a) = " + fCubica(a)); fatv.append(" " + fCubica(a) + "   ");
            System.out.println("f(b) = " + fCubica(b)); fbtv.append(" " + fCubica(b) + "   ");
            System.out.println("f(m) = " + fCubica(m)); fmtv.append(" " + fCubica(m) + "   ");

            System.out.println("f(a)*f(m) = " + fCubica(a) * fCubica(m)); fafmtv.append(" " + fCubica(a)*fCubica(m) + "   ");
            if(fCubica(a) * fCubica(m) > 0) {
                a = m;
            } else {
                b = m;
            }

            mAnterior = m;
            m = (a+b)/2;
            tol = Math.abs((m - mAnterior) / m);

            System.out.println("Error o tolerancia = " + tol); errortv.append(" " + tol + "   ");
            System.out.println("Actual: " + tol + "\nEsperada: " + TOLERANCIA + "\n");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));

    }

    public void falsaCalcularCuadrada(int valorExp, int valorInde, int valorDep, double rangoA, double rangoB, double tolerancia) {

        double xr = a - ( (fCuadrada(a) * (b-a)) / ( fCuadrada(b) - fCuadrada(a)));
        double xrpas = 0;
        double fafxr = fCuadrada(a) * fCuadrada(xr);

        if(fCuadrada(a) * fCuadrada(b) < 0){
            do{
                System.out.println("a = " + a); atv.append(" " + a + "   ");
                System.out.println("b = " + b); btv.append(" " + b + "   ");
                System.out.println("m = " + xr); mtv.append(" " + xr + "   ");
                System.out.println("f(a) = " + fCuadrada(a)); fatv.append(" " + fCuadrada(a) + "   ");
                System.out.println("f(b) = " + fCuadrada(b)); fbtv.append(" " + fCuadrada(b) + "   ");
                System.out.println("f(m) = " + fCuadrada(m)); fmtv.append(" " + fCuadrada(xr) + "   ");

                if(fafxr < 0){
                    b = xr;
                }else if(fafxr > 0){
                    a = xr;
                } else {
                    break;
                }

                xrpas = xr;
                xr = a - ( (fCuadrada(a) * (b-a)) / ( fCuadrada(b) - fCuadrada(a)));
                fafxr = fCuadrada(a) * fCuadrada(xr); fafmtv.append(" " + fCuadrada(a) * fCuadrada(xr) + "   ");
                tol = Math.abs((xr - xrpas) / xr); errortv.append(" " + tol + "   ");

            }while(Math.abs(TOLERANCIA) < Math.abs(tol));

            System.out.println("La raÃ­z es m: " + xr);
        }else{
            System.out.println("No hay raÃ­z.");
        }
    }

    public void falsaCalcularCubica(int valorExp, int valorInde, int valorDep, double rangoA, double rangoB, double tolerancia) {

        double xr = a - ( (fCubica(a) * (b-a)) / ( fCubica(b) - fCubica(a)));
        double xrpas = 0;
        double fafxr = fCubica(a) * fCubica(xr);

        if(fCubica(a) * fCubica(b) < 0){
            do{
                System.out.println("a = " + a); atv.append(" " + a + "   ");
                System.out.println("b = " + b); btv.append(" " + b + "   ");
                System.out.println("m = " + xr); mtv.append(" " + xr + "   ");
                System.out.println("f(a) = " + fCubica(a)); fatv.append(" " + fCubica(a) + "   ");
                System.out.println("f(b) = " + fCubica(b)); fbtv.append(" " + fCubica(b) + "   ");
                System.out.println("f(m) = " + fCubica(m)); fmtv.append(" " + fCubica(xr) + "   ");

                if(fafxr < 0){
                    b = xr;
                }else if(fafxr > 0){
                    a = xr;
                } else {
                    break;
                }

                xrpas = xr;
                xr = a - ( (fCubica(a) * (b-a)) / ( fCubica(b) - fCubica(a)));
                fafxr = fCubica(a) * fCubica(xr); fafmtv.append(" " + fCubica(a)*fCubica(xr) + "   ");
                tol = Math.abs((xr - xrpas) / xr); errortv.append(" " + tol + "   ");

            }while(Math.abs(TOLERANCIA) < Math.abs(tol));

        }else{
            System.out.println("No hay raiz.");
        }

    }

    public void newtonCalcularCuadrada(int valorExp, int valorInde, int valorDep, double aproxa, double tolerancia) {
        double xnPas = 0;
        double error = 0;

        do{
            System.out.println("xn: " + aproxA); xntv.append(" " + aproxA + "   ");
            System.out.println("f(xn): " + fCuadrada(aproxA)); fxntv.append(" " + fCuadrada(aproxA) + "   ");
            System.out.println("f'(xn): " + derivadaFdxCuadrada(aproxA)); fdxntv.append(" " + derivadaFdxCuadrada(aproxA) + "   ");
            System.out.println("Error: " + error);// errortv.append(" " + tol + "   ");
            xnPas = aproxA;
            aproxA = aproxA - ( fCuadrada(aproxA) / derivadaFdxCuadrada(aproxA) );
            error = (aproxA-xnPas)/aproxA;
            error = Math.abs(error);

            tol = Math.abs((aproxA - xnPas) / aproxA); errortv.append(" " + tol + "   ");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));
    }

    public void newtonCalcularCubica(int valorExp, int valorInde, int valorDep, double aproxa, double tolerancia) {
        double xnPas = 0;
        double error = 0;

        do{
            System.out.println("xn: " + aproxA); xntv.append(" " + aproxA + "   ");
            System.out.println("f(xn): " + fCubica(aproxA)); fxntv.append(" " + fCubica(aproxA) + "   ");
            System.out.println("f'(xn): " + derivadaFdxCubica(aproxA)); fdxntv.append(" " + derivadaFdxCubica(aproxA) + "   ");
            System.out.println("Error: " + error);// errortv.append(" " + tol + "   ");
            xnPas = aproxA;
            aproxA = aproxA - ( fCubica(aproxA) / derivadaFdxCubica(aproxA) );
            error = (aproxA-xnPas)/aproxA;
            error = Math.abs(error);

            tol = Math.abs((aproxA - xnPas) / aproxA); errortv.append(" " + tol + "   ");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));
    }

    public void secnateCalcularCuadrada() {

    }

    public void secanteCalcularCubica(int valorExp, int valorInde, int valorDep, double aproxa, double aproxb, double tolerancia) {
//2, 5

        double x2 = 0;
        double errors = 0;

        aproxa = aproxA;
        aproxB = aproxB;

        errors = Math.abs(x1-x0);

        System.out.println("xn: "  + x0); xntv.append(" " + x0 + "   ");
        System.out.println("f(xn)" + fCubica(x0)); fxntv.append(" " + fCubica(x0) + "   ");
        System.out.println("Error: "  + errors); errortv.append(" " + errors + "   ");
        System.out.println("---------------------------");
        while (Math.abs(TOLERANCIA) < Math.abs(tol)) {
            x2 = calXnCubica(x0, x1);
            x0=x1;
            x1=x2;

            errors = Math.abs(x1-x0);

            System.out.println("xn: "  + x2);
            System.out.println("f(xn)" + fCubica(x2));
            System.out.println("Error: "  + errors);
            System.out.println("---------------------------");

            tol = errors; errortv.append(" " + tol + "   ");
        }
        System.out.println("La raiz es: " + x2);
    }

    public double fCuadrada(double x) {
        double f2 = valorExp*(Math.pow(x, 2) + (valorInde * x) + valorDep);
        return f2;
    }

    public double fCubica(double x) {
        double f3 = valorExp*(Math.pow(x, 3) + (valorInde * x) + valorDep);
        if(f3 >= 0) {
            return f3;
        } else {
            return f3;
        }
    }

    public double derivadaFdxCuadrada(double x) {
        double fdx2 = (2*valorExp) * Math.pow(x,1) + valorInde;
        return fdx2;
    }

    public double derivadaFdxCubica(double x) {
        double fdx3 = (3*valorExp) * Math.pow(x,2) + valorInde;
        return fdx3;
    }

    public double calXnCuadrada(double x0, double x1){
        return x1 - (((x1 - x0) * fCuadrada(x1)) / (fCuadrada(x1) - fCuadrada(x0)));
    }

    public double calXnCubica(double x0, double x1){
        return x1 - (((x1-x0) * fCubica(x1)) / (fCubica(x1) - fCubica(x0)));
    }

}
