/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.net.*;
import java.io.*;

public class servidor {

    public static void main(String[] args) {
        
        try {

            ServerSocket s = new ServerSocket(55286);
            while (true) {
                System.out.print("Esperando alguem se conectar...");
                Socket conexao = s.accept();
                System.out.println(" Conectou!");
                DataInputStream entrada = new DataInputStream(conexao.getInputStream());
                DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

                String linha = entrada.readUTF();

                while (linha != null && !(linha.trim().equals(""))) {
                    saida.writeUTF(linha);
                    linha = entrada.readUTF();

                }
                saida.writeUTF(linha);
                conexao.close();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

}
