package ccb.stored.procedure.jobscheduler;

import java.util.List;

import ccb.stored.procedure.jobscheduler.model.Book;
import ccb.stored.procedure.jobscheduler.service.OracleService;

/**
 * Correr Stored Procedure de Oracle
 *
 */
public class App {
	public static void main(String args[]) throws Exception {
		
		System.out.println("Iniciando consulta...");

		OracleService service = new OracleService();
		
		service.invoke("jdbc:oracle:thin:@192.168.251.47:1521:prolinux", "srv_olegprobd", "srv_olegprobd");
		
//		List<Book> books = service.invokeBook("jdbc:oracle:thin:@localhost:1521:XE", "OPENLEGACY", "OPENLEGACY");
//		books.forEach(book -> System.out.println(book));
	}
}