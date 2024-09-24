package pe.edu.cibertec.RueditasBackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.RueditasBackend.Service.EncontrarService;
import pe.edu.cibertec.RueditasBackend.dto.EncontrarRequestDTO;
import pe.edu.cibertec.RueditasBackend.dto.EncontrarResponseDTO;

@RestController
@RequestMapping("/encontrar")
public class EncontrarController {


   @Autowired
   EncontrarService encontrarService;

@PostMapping("/datos")
   public EncontrarResponseDTO encontrar(@RequestBody EncontrarRequestDTO encontrarRequestDTO){

try {
   String[] datosplaca=encontrarService.validarPlaca(encontrarRequestDTO);

   if (datosplaca == null){
      return new EncontrarResponseDTO("01","","","","");
   }

   return new EncontrarResponseDTO(datosplaca[0],datosplaca[1],datosplaca[2],datosplaca[3],datosplaca[4]);
}catch (Exception e){

   System.out.println(e.getMessage());

   return new EncontrarResponseDTO("Error","Error","","","");
}



   }





}
