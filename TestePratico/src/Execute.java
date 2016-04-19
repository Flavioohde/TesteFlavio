
public class Execute {

	
	char [] abertura = {'(','[','{'};
	char [] fechamento = {')',']','}'};
	String estruturais = "()[]{}";
			
	public void execute()
	{
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Execute exec = new Execute();
		
		// teste 1 - OK
		exec.testar("([{a}])");
		
		
		//teste 2 - Erro
		exec.testar("((((a){{{b,c{([abc)]}");
		

	}
	
	public void testar(String palavra) 
	{
		if (validarPalavra(palavra))
			System.out.println("OK A palavra = " + palavra + " esta bem formada!");
		else			
			System.out.println("A palavra = " + palavra + " esta mal formada!");
	}
	
	
	public boolean validarPalavra(String palavra)
	{
		// nivel da estrutura
		int level = 0;

		try
		{
			for (int i = 0; i < palavra.length(); i++)
			{
				level += validateCaracter(palavra.charAt(i),level,i);
			}
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;		
	}
	
	
	public int validateCaracter(char caracter,int level,int posicao) throws Exception
	{
		
        if (bEstrutural(caracter))
        {
        	// é um caracter de abertura correto para este nivel?
    		if (level < abertura.length && abertura[level] == caracter)
    			return 1;

    		 
            // é um caracter de fechamento correto para este nivel?		
    		if (level > 0 && fechamento[level-1] == caracter)
    	       return -1;

    		if (bEstruturalProibido(caracter,level))
    		{
    			// lança erro se caracter proibido para este nivel
    			throw new Exception("Palavra Mal Formada!");
    		}
        }

        // segue validando a palavra sem mudar o nivel
    	return 0;
	}
	

	public boolean bEstrutural(char caracter) throws Exception
	{
		for (int i = 0; i < estruturais.length(); i++)
		{
			if (caracter == estruturais.charAt(i))
			    return true;
				
		}
        return false;		
	}

	public boolean bEstruturalProibido(char caracter,int level) throws Exception
	{
		// é um caracter de abertura proibido para esta posição e nivel?
		for (int i = 0; i < abertura.length; i++)
		{
			if (level != i && caracter == abertura[i])
			{
			    return true;
			}
		}
		
		// é um caracter de fechamento proibido para esta posição e nivel?
		for (int i = 0; i < fechamento.length; i++)
		{
			if (level != i && caracter == fechamento[i-1])
			{
			    return true;
			}
		}
    	
        return false;		
	}

	
	
}
