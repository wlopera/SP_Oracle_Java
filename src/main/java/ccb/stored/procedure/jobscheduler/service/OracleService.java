package ccb.stored.procedure.jobscheduler.service;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ccb.stored.procedure.jobscheduler.model.Book;
import ccb.stored.procedure.jobscheduler.model.OtrTcliOpergaran;
import ccb.stored.procedure.jobscheduler.model.Response;
import ccb.stored.procedure.jobscheduler.util.Mapper;
import oracle.jdbc.OracleTypes;
import oracle.sql.STRUCT;

public class OracleService {

	public List<Book> invoke(String url, String user, String password) throws Exception {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		CallableStatement cstmt = null;
		try {

			con = DriverManager.getConnection(url, user, password);

			System.out.println("Conectado... a la Base de Datos: " + con.getSchema());

			String command = "{call PKG_CCB_CORE_GUARANTEE.PRO_GET_GUARANTEE_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

			cstmt = con.prepareCall(command);

			cstmt.setString("P_FORMAT", "JSON"); // Format
			cstmt.setInt("P_COMPANY", 1); // Company
			cstmt.setString("P_SOURCE", "ATOMOS"); // Source
			cstmt.setInt("P_COUNTRY", 1); // Country
			cstmt.setInt("P_ITEMS_PER_PAGE", 10); // Item X pag
			cstmt.setInt("P_PAGE_NUMBER", 1); // Page Number
			// cstmt.setNull("P_PAGE_NUMBER",OracleTypes.NUMBER);
			cstmt.setInt("P_CODCLIENT", 82316); // Code Cliente
			// cstmt.setNull("P_CODCLIENT",java.sql.Types.INTEGER);
			cstmt.setInt("P_EXTENDUSE", 1); // P Extenduse

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			cstmt.setDate("P_DATETO", new java.sql.Date(sdf.parse("2020/11/12").getTime()));
			// cstmt.setNull("P_DATETO",OracleTypes.DATE);

			// cstmt.setString("P_DATETO", sdate); // Date

			cstmt.registerOutParameter("P_TOTAL_PAGES", OracleTypes.NUMBER); // Total_Pages
			cstmt.registerOutParameter("P_TOTAL_RECORDS", OracleTypes.NUMBER); // Total Recors
			cstmt.registerOutParameter("P_RESPONSE_CODE", OracleTypes.NUMBER); // Response Code
			cstmt.registerOutParameter("P_MESSAGE", OracleTypes.VARCHAR); // Mensagge

			cstmt.registerOutParameter("PTTCLIOPEGARAN", java.sql.Types.ARRAY, "OTT_TCLI_OPERGARANLIST"); // ott_tcli_opergaranlist
			cstmt.registerOutParameter("PTTDETGUARANOPERATIONS", OracleTypes.ARRAY, "OTT_DETGUARANOPERATIONSLIST"); // ott_detGuaranOperationsList
			cstmt.registerOutParameter("PTTOPERATIONSLINKED", OracleTypes.ARRAY, "OTT_OPERATIONSLINKEDLIST"); // ott_OperationsLinkedList
			cstmt.registerOutParameter("PTTGUARANPRORATION", OracleTypes.ARRAY, "OTT_TGAR_PRORRAGARANLIST"); // ott_tgar_prorragaranlist
			cstmt.registerOutParameter("PTTPRORRADISBURMENT", OracleTypes.ARRAY, "OTT_TGAR_PRORRAGARANLIST"); // ott_tgar_prorragaranlist

			System.out.println(cstmt.execute());

			System.out.println("P_RESPONSE_CODE: " + cstmt.getObject("P_RESPONSE_CODE"));
			System.out.println("P_TOTAL_PAGES: " + cstmt.getObject("P_TOTAL_PAGES"));
			System.out.println("P_TOTAL_RECORDS: " + cstmt.getObject("P_TOTAL_RECORDS"));

			System.out.println("P_MESSAGE: " + cstmt.getObject("P_MESSAGE"));

			System.out.println("PTTCLIOPEGARAN: " + cstmt.getObject("PTTCLIOPEGARAN"));

			Response response = new Response();
			response.setCode(new BigDecimal(cstmt.getObject("P_RESPONSE_CODE").toString()));
			response.setTotalPages(new BigDecimal(cstmt.getObject("P_TOTAL_PAGES").toString()));
			response.setTotalRecords(new BigDecimal(cstmt.getObject("P_TOTAL_RECORDS").toString()));
			response.setMessage(cstmt.getObject("P_MESSAGE").toString());

			Array arr = cstmt.getArray("PTTCLIOPEGARAN");

			response.setOtrTcliOpergaran(getOtrTcliOpergaranList(arr.getResultSet()));

			String jsonResponse = Mapper.getResponseJson(response);
			
			System.out.println(jsonResponse);

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}

		}
		return books;
	}

	public List<Book> invokeBook(String url, String user, String password) throws Exception {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		CallableStatement cstmt = null;
		try {

			con = DriverManager.getConnection(url, user, password);

			System.out.println("Conectado... a la Base de Datos: " + con.getSchema());

			String command = "{call FindBooks(?) }";

			cstmt = con.prepareCall(command);

			cstmt.registerOutParameter("book_cursor", OracleTypes.CURSOR);

			System.out.println(cstmt.execute());

			ResultSet rs = (ResultSet) cstmt.getObject("book_cursor");

			Book book = null;
			while (rs.next()) {
				book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("TITULO"));
				book.setAuthor(rs.getString("AUTOR"));
				book.setEditorial(rs.getString("EDITORIAL"));
				books.add(book);
			}

			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}

		}
		return books;
	}

	/**
	 * getOtrTcliOpergaranList Construye la lista de valores OtrTcliOperraram.
	 * 
	 * @param resulSet
	 * 
	 * @return List<OtrTcliOpergaran>
	 */
	private List<OtrTcliOpergaran> getOtrTcliOpergaranList(ResultSet resulSet) {

		List<OtrTcliOpergaran> otrTcliOpergaranList = new ArrayList<>();

		try {
			OtrTcliOpergaran output = null;

			while (resulSet.next()) {

				output = new OtrTcliOpergaran();

				Object elements[] = ((STRUCT) resulSet.getObject(2)).getAttributes();

				output.setOgrCliente(setBigDecimal(elements[0]));
				output.setOgrCodofi(setBigDecimal(elements[1]));
				output.setOgrCodsuc(setBigDecimal(elements[2]));
				output.setOgrCodusr(setBigDecimal(elements[3]));
				output.setOgrCodusre(setBigDecimal(elements[4]));
				output.setOgrFecdesde(setTimeStamp(elements[5]));
				output.setOgrFecha(setTimeStamp(elements[6]));
				output.setOgrFechasta(setTimeStamp(elements[7]));
				output.setOgrFecprot(setTimeStamp(elements[8]));
				output.setOgrGrado(setBigDecimal(elements[9]));
				output.setOgrHipoteca(elements[10] != null ? elements[10].toString() : null);
				output.setOgrMod(setBigDecimal(elements[11]));
				output.setOgrMontosol(setBigDecimal(elements[12]));
				output.setOgrNotaria(elements[13] != null ? elements[13].toString() : null);
				output.setOgrNotario(elements[14] != null ? elements[14].toString() : null);
				output.setOgrNtestimonio(elements[15] != null ? elements[15].toString() : null);
				output.setOgrNumgaran(setBigDecimal(elements[16]));
				output.setOgrNumtra(setBigDecimal(elements[17]));
				output.setOgrNumtrae(setBigDecimal(elements[18]));
				output.setOgrOperacion(setBigDecimal(elements[19]));
				output.setOgrRelacion(elements[20] != null ? elements[20].toString() : null);
				output.setOgrSaldoant(setBigDecimal(elements[21]));
				output.setOgrSaldocom(setBigDecimal(elements[22]));
				output.setOgrSecuencia(setBigDecimal(elements[23]));
				output.setOgrValor(setBigDecimal(elements[24]));

				otrTcliOpergaranList.add(output);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return otrTcliOpergaranList;
	}

	/**
	 * setBigDecimal Genera un valor BigDecimal o nulo.
	 * 
	 * @param value BigDecimal
	 * @return
	 */
	private BigDecimal setBigDecimal(Object value) {
		return value != null ? new BigDecimal(value.toString()) : null;
	}

	/**
	 * setTimeStamp Genera un valor TimeStamp.
	 * 
	 * @param value Timestamp
	 * @return
	 */
	private Timestamp setTimeStamp(Object value) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

		try {
			return value != null ? new Timestamp(format.parse(value.toString()).getTime()) : null;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return null;
	}
}
