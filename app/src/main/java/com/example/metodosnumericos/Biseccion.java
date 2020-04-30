package com.example.metodosnumericos;


public class Biseccion {

    public static int valorExp, valorInde, valorDep;

    public static double a;
    public static double b;
    public static double m;
    public static double mAnterior;
    public static final double TOLERANCIA = -1E-3;
    public static double tol;


    public static void main(String[] args) {
        Biseccion bis = new Biseccion();


        valorExp = 1;
        valorInde = -5;
        valorDep = 1;
        a = 0;
        b = 1;
        tol = 0;
        mAnterior = 0;

        System.out.println("Tolerancia de operacion: " + tol
                + "\nTolerancia de resultado: " + TOLERANCIA);
        do {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("m = " + m);

            System.out.println("f(a) = " + bis.fCubica(a));
            System.out.println("f(b) = " + bis.fCubica(b));
            System.out.println("f(m) = " + bis.fCubica(m));

            System.out.println("f(a)*f(m) = " + bis.fCubica(a)*bis.fCubica(m));
            if(bis.fCubica(a)*bis.fCubica(m) > 0) {
                a = m;
            } else {
                b = m;
            }

            mAnterior = m;
            m = (a+b)/2;
            tol = Math.abs((m - mAnterior)/m);

            System.out.println("Error o tolerancia = " + tol);
            System.out.println("Actual: " + tol + "\nEsperada: " + TOLERANCIA + "\n");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));
    }

    public void calcularFcuadrada(int valorExp, int valorInde, int valorDep, int rangoA, int rangoB, int tolerancia){
        mAnterior = 0;

        System.out.println("Tolerancia de operacion: " + tol
                + "\nTolerancia de resultado: " + TOLERANCIA);
        do {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("m = " + m);

            System.out.println("f(a) = " + fCuadrada(a));
            System.out.println("f(b) = " + fCuadrada(b));
            System.out.println("f(m) = " + fCuadrada(m));

            System.out.println("f(a)*f(m) = " + fCuadrada(a) * fCuadrada(m));
            if(fCuadrada(a) * fCuadrada(m) > 0) {
                a = m;
            } else {
                b = m;
            }

            mAnterior = m;
            m = (a+b)/2;
            tol = Math.abs((m - mAnterior) / m);

            System.out.println("Error o tolerancia = " + tol);
            System.out.println("Actual: " + tol + "\nEsperada: " + TOLERANCIA + "\n");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));
    }

    public void calcularFcubica(int valorExp, int valorInde, int valorDep, int rangoA, int rangoB, double tolerancia){

        mAnterior = 0;

        System.out.println("Tolerancia de operacion: " + tol
                + "\nTolerancia de resultado: " + TOLERANCIA);
        do {
            System.out.println("a = " + a);
            System.out.println("b = " + b);

            //m=(a+b)/2;

            System.out.println("m = " + m);

            System.out.println("f(a) = " + fCubica(a));
            System.out.println("f(b) = " + fCubica(b));
            System.out.println("f(m) = " + fCubica(m));

            System.out.println("f(a)*f(m) = " + fCubica(a) * fCubica(m));
            if(fCubica(a) * fCubica(m) > 0) {
                a = m;
            } else {
                b = m;
            }

            mAnterior = m;
            //m = (a+b)/2;
            tol = Math.abs((m - mAnterior) / m);

            System.out.println("Error o tolerancia = " + tol);
            System.out.println("Actual: " + tol + "\nEsperada: " + TOLERANCIA + "\n");

        }while(Math.abs(TOLERANCIA) < Math.abs(tol));
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
}
