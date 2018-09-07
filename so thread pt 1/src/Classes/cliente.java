/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.net.*;
import java.io.*;

public class cliente {
    public static void main(String [] args ) {
    try {

            Socket conexao = new Socket("127.0.0.1", 55286);

            DataInputStream entrada = new DataInputStream(
                    conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(
                    conexao.getOutputStream());
            
            String linha;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("> ");
                linha = teclado.readLine();
                saida.writeUTF(linha);
                linha = entrada.readUTF();
                if (linha.equalsIgnoreCase("")) {
                    System.out.println("Conexao encerrada!");
                    break;
                }
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }   
    }}

    
