package ce1103.ChefREST.utility;

public class ParserId {
	
	public int parseString(String idString){
		char token;
		int suma = 0;
		for(int i = 0; i< idString.length(); i++){
			token = idString.charAt(i);
			suma = suma + sumChar(token);
		}
		return suma;
	}
	
	private int sumChar(char token){
		int sum = 0;
		if(token == 'a' || token == 'A'){
			sum = 1;
		}else if(token == 'b' || token == 'B'){
			sum = 2;
		}else if(token == 'c' || token == 'C'){
			sum = 3;
		}else if(token == 'd' || token == 'D'){
			sum = 4;
		}else if(token == 'e' || token == 'E'){
			sum = 5;
		}else if(token == 'f' || token == 'F'){
			sum = 6;
		}else if(token == 'g' || token == 'G'){
			sum = 7;
		}else if(token == 'h' || token == 'H'){
			sum = 8;
		}else if(token == 'i' || token == 'I'){
			sum = 9;
		}else if(token == 'j' || token == 'J'){
			sum = 10;
		}else if(token == 'k' || token == 'K'){
			sum = 11;
		}else if(token == 'l' || token == 'L'){
			sum = 12;
		}else if(token == 'm' || token == 'M'){
			sum = 13;
		}else if(token == 'n' || token == 'N'){
			sum = 14;
		}else if(token == 'ñ' || token == 'Ñ'){
			sum = 15;
		}else if(token == 'o' || token == 'O'){
			sum = 16;
		}else if(token == 'p' || token == 'P'){
			sum = 17;
		}else if(token == 'q' || token == 'Q'){
			sum = 18;
		}else if(token == 'r' || token == 'R'){
			sum = 19;
		}else if(token == 's' || token == 'S'){
			sum = 20;
		}else if(token == 't' || token == 'T'){
			sum = 21;
		}else if(token == 'u' || token == 'U'){
			sum = 22;
		}else if(token == 'v' || token == 'V'){
			sum = 23;
		}else if(token == 'w' || token == 'W'){
			sum = 24;
		}else if(token == 'x' || token == 'X'){
			sum = 25;
		}else if(token == 'y' || token == 'Y'){
			sum = 26;
		}else if(token == 'z' || token == 'Z'){
			sum = 27;
		}
		return sum;
	}
	
}
