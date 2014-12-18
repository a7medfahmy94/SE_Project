/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import java.util.Scanner;

/**
 *
 * @author fahmy
 */
public class Task {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str    = input.nextLine();
        String odd = "";
        String even = "";
        
        for(int i=0;i<str.length();i++){
            if((str.charAt(i))%2==0){
                even += str.charAt(i);
            }else{
                odd += str.charAt(i);
            }
        }
        System.out.println(odd);
        System.out.println(even);
    }
    
}
