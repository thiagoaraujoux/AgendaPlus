package br.unitins.agendaplus.application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;

import br.unitins.agendaplus.model.Usuario;
import br.unitins.agendaplus.servlet.ImgUsuarioServlet;

public class Util {

	public static void main(String[] args) {
		System.out.println(hash("janio"));
		System.out.println(hash("janio"));
		System.out.println(hash("Janio").length());
	}

	public static void redirect(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			System.out.println("Não foi possível realizar o redirecionamento.");
			e.printStackTrace();
		}
	}

	public static String hash(Usuario usuario) {
		return hash(usuario.getLogin() + usuario.getSenha());
	}

	private static String hash(String valor) {
		return DigestUtils.sha256Hex(valor);
	}

	private static void addMessage(String msg, Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, null));
	}

	public static void addErrorMessage(String msg) {
		addMessage(msg, FacesMessage.SEVERITY_ERROR);
	}

	public static void addWarnMessage(String msg) {
		addMessage(msg, FacesMessage.SEVERITY_WARN);
	}

	public static void addInfoMessage(String msg) {
		addMessage(msg, FacesMessage.SEVERITY_INFO);
	}

	public static boolean saveImageUsuario(InputStream inputStream, String imageType, int idUsuario) {
		// Exemplo da maquina do janio: /home/janio/images/usuario
		String diretorio = System.getProperty("user.home") + ImgUsuarioServlet.PATH_IMAGES_USUARIO;

		// Criando os diretorios caso nao exista
		File file = new File(diretorio);
		if (!file.exists()) {
			file.mkdirs(); // mkdirs - cria arquivo ou diretorio (caso o diretorio anterior nao exista ele
							// cria tambem)
		}

		try {
			// criando o espaco de memoria para armazenamento de uma imagem
			// inputStream - eh o fluxo de dados de entrada
			BufferedImage bImage = ImageIO.read(inputStream);

			// estrutura final do arquivo ex: /home/janio/images/usuario/01.png
			File arquivoFinal = new File(diretorio + File.separator + idUsuario + "." + imageType);
			// salvando a imagem
			// buffer da imagem, png/gif, 01.png
			ImageIO.write(bImage, imageType, arquivoFinal);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

}