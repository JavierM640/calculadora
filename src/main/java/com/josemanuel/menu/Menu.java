package com.josemanuel.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Menu {

    private Scanner sc;
    private String titulo;
    private String input;
    private Map<String, ItemMenu> mapItemMenu;
    

    //Creamos el constructor del menu
    public Menu(String titulo, String input, Map<String, ItemMenu> mapItemMenu, Scanner sc) {

        this.sc = sc;
        this.mapItemMenu = mapItemMenu;
        this.titulo = titulo;
        this.input = input;

    }

    public void renderiza() {

        System.out.println(titulo);
         
        this.mapItemMenu.forEach((k, v) -> {
            System.out.println(k + ".- " + v.getMensajeMenu());
        });

        System.out.println(this.input);

    }

    //Creamos el bucle para la creación del menú y del submenú
    public void bucle() throws ExitMenuException {

        
        do{

            this.renderiza();            
            String next = sc.next();
            ItemMenu itemMenuSelect = this.mapItemMenu.get(next);
            if (itemMenuSelect != null) {
                Menu subMenu;
                if ((subMenu = itemMenuSelect.getSubMenu())!= null) {                
                    try {
                        subMenu.bucle();
                    } catch(ExitMenuException eme) {                    
                    }
                } 

                Function<Scanner, Void> itemMenuFuncion;
                if ((itemMenuFuncion = itemMenuSelect.getItemMenuFuncion()) != null) {
                    itemMenuFuncion.apply(sc);
                }
                  
            } else {
                System.out.println("Opción no válida, intente de nuevo");
            }
            
        } while(true);

    }



    
    
}
