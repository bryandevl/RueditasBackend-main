package pe.edu.cibertec.RueditasBackend.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.RueditasBackend.Service.EncontrarService;
import pe.edu.cibertec.RueditasBackend.dto.EncontrarRequestDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EncontrarServiceimpl implements EncontrarService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(EncontrarRequestDTO encontrarRequestDTO) throws IOException {


        String[] datosplaca=null;
        Resource resource= resourceLoader.getResource("classpath:Placa.txt");



        try(BufferedReader br=new BufferedReader(new FileReader(resource.getFile()))) {


       String linea;

       while((linea=br.readLine())!=null){


           String[] datos=linea.split(";");

           if (encontrarRequestDTO.Placa().equals(datos[0])){

               datosplaca=new String[5];
               datosplaca[0]=datos[1];//Recuperar Marca
               datosplaca[1]=datos[2];//Modelo
               datosplaca[2]=datos[3];//Nro asiento
               datosplaca[3]=datos[4];//Precio
               datosplaca[4]=datos[5];//Color

           }

       }







}catch (IOException e){
            datosplaca=null;
            throw new IOException(e);
  }









        return datosplaca;
    }
}
