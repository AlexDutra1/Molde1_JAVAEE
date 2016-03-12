package br.com.controller;

import java.io.Serializable;
import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.controller.formulario.UsuarioFormulario;
import br.com.modelo.Usuario;
import br.com.servico.UsuarioService;

@RequestScoped
@Named
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService service;
	
	@Inject
	private UsuarioFormulario formulario;
		
	//TESTE
	private byte[] imagem;
	
	public void salvarCadastro(){
		
		this.getService().getNegocios().getDao().guardar(this.getFormulario().getUsuario());

		//Limpa campos apos cadastro
		this.formulario.setUsuario(new Usuario());
	}
	
	public void pesquisar(){

		this.formulario.setTodosUsuarios(this.service
				.getNegocios().getDao()
				.pesquisarComCriterios(this.formulario.getUsuario()));
		
		//ATUALIZA TABELA E CAMPO DE PESQUISA
		RequestContext.getCurrentInstance().update(Arrays.asList("formPesquisaUsuario:tabelaUsuarios"));
		
		//Limpa campos apos cadastro
		this.formulario.getUsuario().setNome("");
		this.formulario.getUsuario().setEmail("");
		this.formulario.getUsuario().setUsuario("");
		
		//ATUALIZA CAMPOS
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_nome");
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_usuario");
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_email");
		
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
