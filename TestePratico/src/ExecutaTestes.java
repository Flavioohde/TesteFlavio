import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class ExecutaTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Result result = JUnitCore.runClasses(TestaPalavras.class);
	
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
		 if (result.wasSuccessful()){
			 System.out.println();		
			 System.out.println("SUCESSO: Todos os Resultados dentro do esperado!");		
		 }
		 else{
			 System.out.println();		
			 System.out.println("ATENÇAO: Testes fora do esperado!");		

		 }
			 

	}

}
