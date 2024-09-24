package pe.edu.cibertec.RueditasBackend.Service;

import pe.edu.cibertec.RueditasBackend.Service.impl.EncontrarServiceimpl;
import pe.edu.cibertec.RueditasBackend.dto.EncontrarRequestDTO;

import java.io.IOException;

public interface EncontrarService  {


    String[] validarPlaca(EncontrarRequestDTO encontrarRequestDTO) throws IOException;
}
