package ccb.stored.procedure.jobscheduler.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ccb.stored.procedure.jobscheduler.model.OtrTcliOpergaran;
import ccb.stored.procedure.jobscheduler.model.Response;

/**
 * Mapper Conversiones Objetos <=> Json.
 * 
 * @author con_wlopera
 */
public class Mapper {

	private Mapper() {
	}

	/**
	 * Sring con el Json de la respuesta.
	 * 
	 * @param input
	 * 
	 * @author con_wlopera
	 * 
	 * @return
	 */
	public static String getResponseJson(Response input) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.S").create();

		return gson.toJson(input);
	}

	/**
	 * Objecto con los datos de la respuesta.
	 * 
	 * @param input
	 * 
	 * @author con_wlopera
	 * 
	 * @return
	 */

	public static Response getResponse(String input) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.S").create();

		return gson.fromJson(input, Response.class);
	}

	/**
	 * Sring con el Json de la data.
	 * 
	 * @param input
	 * 
	 * @author con_wlopera
	 * 
	 * @return
	 */
	public static String getOtrTcliOpergaranJson(List<OtrTcliOpergaran> input) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.S").create();

		return gson.toJson(input);
	}

	/**
	 * Objecto con los datos OtrTcliOpergaran.
	 * 
	 * @param input
	 * 
	 * @author con_wlopera
	 * 
	 * @return
	 */

	public static ArrayList<OtrTcliOpergaran> getOtrTcliOpergaran(String input) {
		Gson gson = new Gson();

		@SuppressWarnings("serial")
		Type listType = new TypeToken<ArrayList<OtrTcliOpergaran>>() {
		}.getType();

		return gson.fromJson(input, listType);
	}

}
