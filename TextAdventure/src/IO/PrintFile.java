/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MaxM
 */
public class PrintFile {
    public void Print(String input, String FilePath) throws IOException
    {
        FileWriter writer = new FileWriter(FilePath);
        writer.write(input);
        writer.flush();
        writer.close();
    }
}
