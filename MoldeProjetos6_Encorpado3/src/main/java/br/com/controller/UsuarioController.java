package br.com.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.controller.formulario.UsuarioFormulario;
import br.com.modelo.Usuario;
import br.com.servico.UsuarioService;

@RequestScoped
@Named
public class UsuarioController {

	@Inject
	private UsuarioService service;
	
	@Inject
	private UsuarioFormulario formulario;
	
	//TESTE
	private byte[] imagem;
	
	public void salvarCadastro(){
		
		this.formulario.setUsuario(new Usuario());
		
		this.getService().getNegocios().getDao().guardar(this.getFormulario().getUsuario());
		
	}
	
	/**
	 * Metodo responsanvel por salvar aquivo
	 * @param fileUploadEvent
	 */
	public void doUpload(FileUploadEvent fileUploadEvent) { 
    
		UploadedFile uploadedFile = fileUploadEvent.getFile();  
        String fileNameUploaded = uploadedFile.getFileName(); 
        long fileSizeUploaded = uploadedFile.getSize(); 
        String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded +"</b><br/>"+
            "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>";
        

        //SALVA O ARQUI EM imagem
        this.setImagem(fileUploadEvent.getFile().getContents());
        //Renderiza formulario
        //imagem = fileUploadEvent.getFile().getContents();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("Sucesso", 			                                                                       infoAboutFile));
	
	}

	
	public String abreCadastro(){
		
		return "cadastroUsuario";
	}
	
	
	public String abrePesquisa(){
		
		return "pesquisaUsuario";
	}

	public byte[] getImagem() {
		return imagem;
	}


	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	public UsuarioFormulario getFormulario() {
		return formulario;
	}

	public void setFormulario(UsuarioFormulario formulario) {
		this.formulario = formulario;
	}


	
	
}
