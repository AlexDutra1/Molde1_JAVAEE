package br.com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.controller.formulario.UsuarioFormulario;
import br.com.modelo.Usuario;
import br.com.servico.UsuarioService;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService service;
	
	@Inject
	private UsuarioFormulario formulario;
	
	//TESTE
	private byte[] imagem;
		
	@PostConstruct
	public void init(){
		
		//this.formulario.setTodosUsuarios(this.service.getNegocios().getDao().consultarTodosUsuariosDAO());

	}
	
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
		RequestContext.getCurrentInstance().update(Arrays.asList("formPesquisaUsuario:tabelaConsultaUsuarios"));
		
		//Limpa campos apos cadastro
		//this.formulario.getUsuario().setNome("");
		//this.formulario.getUsuario().setEmail("");
		//this.formulario.getUsuario().setUsuario("");
		
		//ATUALIZA CAMPOS
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_nome");
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_usuario");
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_email");
		
	}
	
	public void processFileUpload(FileUploadEvent uploadEvent) {
		 
        try {
            //foto.setProduto(produtoSelecionado);
            formulario.setImagem(uploadEvent.getFile().getContents());
            //foto.setImagem(uploadEvent.getFile().getContents());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
    }
	
	public void fileUpload(FileUploadEvent event, String type, String diretorio) {
		
		try {
			//this.nome = new java.util.Date().getTime() + type;
			//this.caminho = getRealPath() + diretorio + getNome();
			//this.arquivo = event.getFile().getContents();
			this.formulario.setImagem(event.getFile().getContents());
			//File file = new File(getRealPath() + diretorio);
			//file.mkdirs();
			
		} catch (Exception ex) {
			System.out.println("Erro no upload do arquivo" + ex);
		}
	}
	
	private byte[] arquivo; 
	
	private Part arquivoB;
	
	/*public void save() {
	    try (InputStream input = arquivoB.getInputStream()) {
	        Files.copy(input, new File(uploads, filename).toPath());
	    }
	    catch (IOException e) {
	        // Show faces message?
	    }
	}*/
	
	//RASCUNHO
	/*
	<h:form id="form" enctype="multipart/form-data">
	<h:outputLabel value="Arquivo" for="arquivo" />
	<h:inputFile id="arquivo" value="#{importadorBean.arquivo}"
		required="true" label="Arquivo" />
	<h:commandButton value="Importar"
		action="#{importadorBean.importa}">
		</h:commandButton>
							
</h:form>
	*/
	public void importa(ActionEvent event) {
        try {
            String conteudo = new Scanner(arquivoB.getInputStream())
                .useDelimiter("\\A").next();
        } catch (IOException e) {
            // trata o erro
        }
    }
	
	/*
	public String upload() throws IOException {
        InputStream inputStream = arquivoB.getInputStream();        
       FileOutputStream outputStream = new FileOutputStream(getFilename(arquivoB));
        
       byte[] buffer = new byte[4096];        
       int bytesRead = 0;
       while(true) {                        
           bytesRead = inputStream.read(buffer);
           if(bytesRead > 0) {
               outputStream.write(buffer, 0, bytesRead);
           }else {
               break;
           }                       
       }
       outputStream.close();
       inputStream.close();
       
       return "success";
   }
*/
  /* private static String getFilename(Part part) {
       for (String cd : part.getHeader("content-disposition").split(";")) {
           if (cd.trim().startsWith("filename")) {
               String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
               return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
           }
       }
       return null;
   }*/
   
   public void handleFileUpload(AjaxBehaviorEvent event) {
	    System.out.println("file size: " + arquivoB.getSize());
	    System.out.println("file type: " + arquivoB.getContentType());
	    System.out.println("file info: " + arquivoB.getHeader("Content-Disposition"));
	}
   
	
 
    
    /*RASCUNHO 
	<!-- 
	<div class="col-md-12 form-group">
		<h:graphicImage library="img" name="que_lindo.jpg"/>				
		<h:graphicImage id="teste1" value="#{usuarioController.formulario.imagem}"/>

		<h:inputFile value="#{usuarioController.formulario.imagem}" />
			<h:commandButton action="#{usuarioController.salvar}" value="Enviar" />
	</div>
	 -->
	 */
   


    public void salvar(){
    	
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

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Part getArquivoB() {
		return arquivoB;
	}

	public void setArquivoB(Part arquivoB) {
		this.arquivoB = arquivoB;
	}

	

	
	
}
