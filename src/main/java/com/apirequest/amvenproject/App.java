package com.apirequest.amvenproject;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class App 
{
    public static void main( String[] args )
    {
    	
    	granjitaAnularTicket();
		
    }
    
    public static void DelJugada() {
    	
    	String CodVal="";
		String SerTic="";
		
		try {
			HttpResponse<String> response =  Unirest.post("http://app.maticlot.com/wsReportes.asmx")
			  .header("SOAPAction", "http://app.maticlot.com/getResSor")
			  .header("Content-Type", "text/xml")
			  .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n    <soap:Body>\r\n        <getResSor xmlns=\"http://app.maticlot.com/\">\r\n            <CodVal>"+CodVal+"</CodVal>\r\n            <SerTic>"+SerTic+"</SerTic>\r\n        </getResSor>\r\n    </soap:Body>\r\n</soap:Envelope>")
			  .asString();
			String[] mensaje=response.getBody().split("<getResSorResult>");
			mensaje=mensaje[1].split("<");
			
			System.out.println(mensaje[0]);
		} catch (UnirestException e) {
			
			e.printStackTrace();
		}
		
    }
    
    
    
    public static void venReg() {
    	String CodVal="k!eM@.Fcp1x8hPWd";
		String codCom="Athenas";
		String codAge = "age34";
		String idTic = "6658";
		String idMon = "1";
		String Jugada="<t><J><s>1614</s><x>0</x><n>78</n><a>0</a><m>3.00</m></J></t>";
		int idTicInt=Integer.parseInt(idTic);
		if(idTicInt>2147483647) {
			System.out.println("El id de cliente excede el permitido");
		}else {
			HttpResponse<String> response = null;
			try {
				response = Unirest.post("http://app.maticlot.com/wsReportes.asmx")
						  .header("SOAPAction", "http://app.maticlot.com/VenReg")
						  .header("Content-Type", "text/xml")
						  .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n  <soap12:Body>\r\n    <VenReg xmlns=\"http://app.maticlot.com/\">\r\n      <CodVal>"+CodVal+"</CodVal>\r\n      <CodCom>"+codCom+"</CodCom>\r\n      <CodAge>"+codAge+"</CodAge>\r\n      <idTic>"+idTic+"</idTic>\r\n      <idMon>"+idMon+"</idMon>\r\n      <Jugada>\r\n      <![CDATA["+Jugada+"]]></Jugada>\r\n    </VenReg>\r\n  </soap12:Body>\r\n</soap12:Envelope>")
						  .asString();
			} catch (UnirestException e) {
				e.printStackTrace();
			}
			String[] mensaje=response.getBody().split("<VenRegResult>");
					mensaje=mensaje[1].split("<");
					System.out.println(mensaje[0]);
		}
	}
		
    
    
    public static void getResSor() {
    	String CodVal="k!eM@.Fcp1x8hPWd";
		String FecSor="20180207-13";
		
		try {
			HttpResponse<String> response =  Unirest.post("http://app.maticlot.com/wsReportes.asmx")
			  .header("SOAPAction", "http://app.maticlot.com/getResSor")
			  .header("Content-Type", "text/xml")
			  .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n    <soap:Body>\r\n        <getResSor xmlns=\"http://app.maticlot.com/\">\r\n            <CodVal>"+CodVal+"</CodVal>\r\n            <FecSor>"+FecSor+"</FecSor>\r\n        </getResSor>\r\n    </soap:Body>\r\n</soap:Envelope>")
			  .asString();
			String[] mensaje=response.getBody().split("<getResSorResult>");
			mensaje=mensaje[1].split("<");
			
			System.out.println(mensaje[0]);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
    }

	public static void granjitaLogin(){
		String usuario="TAQ_LOTIPLAY_VES";
		String password="48cp?qNxxstiPFGDgnd&";
		String serial="syam123456";
		try {
			HttpResponse<String> response =  Unirest.post("http://dev.premierpluss.com:2053/users/token-v2/"+serial)
			  .header("Content-Type", "application/json")
			  .body("{\"username\": \""+usuario+"\",\"password\": \""+password+"\",\"device_info\": {\"system_name\": \"syam\",\"app_name\": \"INTEGRATION\",\"app_version\": \"2\"}}")
			  .asString();
			String mensaje=response.getBody();
			System.out.println(mensaje);
		}catch(UnirestException e){
			e.printStackTrace();
		}

	}
	public static void granjitaGetRes(){
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjk5NzMsImV4cCI6MTY2NDEwMTgyM30.y3-ycKSnPVJ7fM6yuWxy-RNF0I0sXqoOp_y9T5Htjcs";
		try {
			HttpResponse<String> response =  Unirest.post("http://dev.premierpluss.com:2053/loteries/get-sorteos-v2")
			  .header("Content-Type", "application/json")
			  .header("Authorization", "Bearer "+token)
			  .asString();
			String mensaje=response.getBody();
			System.out.println(mensaje);
		}catch(UnirestException e){
			e.printStackTrace();
		}

	}


	public static void granjitaSendTicket(){
		String numero="0";
		int loteria=9;
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjk5NzMsImV4cCI6MTY2NDEwMTgyM30.y3-ycKSnPVJ7fM6yuWxy-RNF0I0sXqoOp_y9T5Htjcs";
		double monto=0.5;
		try {
			HttpResponse<String> response =  Unirest.post("http://dev.premierpluss.com:2053/tickets/add-v2")
			  .header("Content-Type", "application/json")
			  .header("Authorization", "Bearer "+token)
			  .body("{\"bets\": [{\"number\": \""+numero+"\",\"lotery_id\":"+loteria+",\"amount\": "+monto+"}]}")
			  .asString();
			String mensaje=response.getBody();
			System.out.println(mensaje);
		}catch(UnirestException e){
			e.printStackTrace();
		}

	}
	public static void granjitaAnularTicket(){
		int numero=10214334;
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjk5NzMsImV4cCI6MTY2NDEwMTgyM30.y3-ycKSnPVJ7fM6yuWxy-RNF0I0sXqoOp_y9T5Htjcs";
		try {
			HttpResponse<String> response =  Unirest.post("http://dev.premierpluss.com:2053/tickets/anull-v2")
			  .header("Content-Type", "application/json")
			  .header("Authorization", "Bearer "+token)
			  .body("{\"number\": "+numero+"}")
			  .asString();
			String mensaje=response.getBody();
			System.out.println(mensaje);
		}catch(UnirestException e){
			e.printStackTrace();
		}

	}
}
