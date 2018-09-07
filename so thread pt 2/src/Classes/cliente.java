/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.net.*;
import java.io.*;

public class cliente extends Thread {

    public static boolean done = false;
    private Socket conexao;
    
    public  cliente (Socket conexao)
    {
            this. conexao = conexao;
    }
    public  static  void  

m

a i

    n(String[] args) {

        try {

            Socket conexao = new Socket("localhost", 2000);

            PrintStream saida = new PrintStream(conexao.getOutputStream());

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.i

n

            )

)

;

                        System.o u

            t
                    .print("Entre  com  o  seu  nome:  ");

            String meuNome = teclado.readLine();

            saida.println(meuNome);

            Thread t = new Cliente(conexao);

            t.start();

            String linha;

            while (true) {

                if (d


                    o

n

e

                
                    )

{

                                        break;

                }

                System.o u

                t
                        .println(">  ");

                linha = teclado.readLine();

                saida.println(linha);

            }

        } catch (IOException e) {

            System.o u

            t
                    .println("IOException:  " + e)
    
    
    
    
    
    
    
    
}
