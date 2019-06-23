package negocio;

import java.io.ObjectInputStream.GetField;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Pedido;

public class JavaMailApp {

	public static void enviarEmailParraEntregador(Pedido pedido) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.StSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("email.teste325465@gmail.com", "diamante42@");
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("email.teste325465@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress // Destinatário(s)
					.parse(pedido.getEntregador().getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Pedido de número: " + pedido.getCodigo());// Assunto
			message.setText(
					"Loja:" + pedido.getLoja().getNome() + "\n\tEndereco da loja:" + pedido.getLoja().getEndereco()
							+ "\nCliente:" + pedido.getCliente().getNome() + "\n\tEndereco do cliente:"
							+ pedido.getCliente().getEndereco() + "Total a ser pago" + pedido.getValorTotal());

			/** Método para enviar a mensagem criada */

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}