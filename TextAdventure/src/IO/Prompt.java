/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MaxM
 */
public class Prompt {
    
    public void Tell(ArrayList<String> output)
    {
        for(String line : output)
        {
            System.out.println(line);
        }
    }
    
    public String Ask(ArrayList<String> output)
    {
        this.Tell(output);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}
