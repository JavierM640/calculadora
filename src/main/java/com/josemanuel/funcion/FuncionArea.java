package com.josemanuel.funcion;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

public class FuncionArea implements Function<Scanner, Void>{

    @Override
    //Creación de la función del area
    public Void apply(Scanner sc) {
        
        System.out.println(" P * A / 2");
        
        System.out.println("Introduzca (P)erímetro:");
        String pStr = sc.next();
        BigDecimal pBD = new BigDecimal(pStr);

        System.out.println("Introduzca (A)potema:");
        String aStr = sc.next();
        BigDecimal aBD = new BigDecimal(aStr);

        //Operamos y mostramos el resultado
        System.out.println("Resultado" + pBD.multiply(aBD).divide(BigDecimal.valueOf(2)).toString());

        return null;
    }

    
}
