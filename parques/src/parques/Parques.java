/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parques;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Parques {
    public  static  int menu(){
        int op=0;
        Scanner s = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("1- listar parques por ciudad");
        System.out.println("2- añadir ciudad");
        System.out.println("3- añadir parque a una ciudad");
        System.out.println("4- editar parque");
        System.out.println("5- parques que contene 'cadena' en su nombre");
        System.out.println("6- numero de parques de una ciudad");
        System.out.println("7- borrarr todos los parques de una ciudad");
        System.out.println("8- ciudades con parques mayotrs a una extension");
        System.out.println("9- salir");
        System.out.println("***************************************");
        System.out.println("dime una opcion");
        op=s.nextInt();
        return op;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Bd parques =new Bd();
       boolean salir=false;
        while(!salir){
            switch(menu()){
                case 1:{
                    Scanner s = new Scanner(System.in);
                    System.out.println("dime el nombre de la ciudad");
                    String aux = s.nextLine();
                    System.out.println("****************"+"\n"+parques.mostrarParquesPorCiudad(aux)+"****************");
                    break;
                }
                case 2:{
                     Scanner s = new Scanner(System.in);
                    System.out.println("dime el nombre de la ciudad");
                    String aux = s.nextLine();
                    parques.añadirCiudad(aux);
                    break;
                }
                case 3:{
                     Scanner s = new Scanner(System.in);
                     Scanner ss = new Scanner(System.in);
                     Scanner sss = new Scanner(System.in);
                    System.out.println("dime el nombre del parque");
                    String parque = s.nextLine();
                    System.out.println("dime la extension");
                    String exten = s.nextLine();
                    System.out.println("dime el nombre de la ciudad");
                    String ciudad = s.nextLine();
                    parques.añadirParque(ciudad, parque, exten);
                    break;
                }
                case 4:{
                    
                    break;
                }
                case 5:{
                    Scanner s = new Scanner(System.in);
                    System.out.println("dime el nombre de la cadena");
                    String aux = s.nextLine();
                    System.out.println("****************"+"\n"+parques.mostrarParquesPorCadena(aux)+"****************");
                    break;
                }
                case 6:{
                    Scanner s = new Scanner(System.in);
                    System.out.println("dime el nombre de la ciudad");
                    String aux = s.nextLine();
                    System.out.println("****************"+"\n"+parques.contarParquesPorCiudad(aux)+"\n"+"****************");
                    break;
                }
                case 7:{
                    Scanner s = new Scanner(System.in);
                    System.out.println("dime el nombre de la ciudad");
                    String aux = s.nextLine();
                    parques.borrarParque(aux);
                    break;
                }
                case 8:{
                    Scanner s = new Scanner(System.in);
                    System.out.println("dime el nombre de la extension");
                    String aux = s.nextLine();
                   System.out.println("****************"+"\n"+parques.mostrarCiudadesPorExtension(aux)+"\n"+"****************");
                    break;
                }
                case 9:{
                    salir=true;
                    break;
                }
            }
        }
    }
    
}
