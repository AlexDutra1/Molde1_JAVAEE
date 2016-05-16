package br.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.output.ByteArrayOutputStream;


@ApplicationScoped
@Named("importadorBean")
public class ImportadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Part arquivo; 
	private byte[] arquivo_B; 

    public void importa() {
        try {
            String conteudo = new Scanner(arquivo.getInputStream()).useDelimiter("\\A").next();
            System.out.println("CONTEUDO: "+conteudo);
            
            //Converte de Part para Array de Bytes
            arquivo_B=this.getFileContents(arquivo.getInputStream());
            //arquivo_B é um array de bytes
            
        } catch (IOException e) {
            // trata o erro
        }
    }
    
    //ESSA FUNCAO TRANSFORMA ARQUIVO DO TIPO PART EM BYTES
    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {            
            // write the inputStream to a FileOutputStream            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
             bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
            bytes = bos.toByteArray();
            in.close();
            in = null;
            bos.flush();
            bos.close();
            bos = null;
            System.out.println("CRIADOoooooooooooo");
            //logger.debug("New file created!");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }
   

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public byte[] getArquivo_B() {
		return arquivo_B;
	}

	public void setArquivo_B(byte[] arquivo_B) {
		this.arquivo_B = arquivo_B;
	}

}
