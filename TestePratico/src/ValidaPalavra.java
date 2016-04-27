
public class ValidaPalavra {

	
	static char [] abertura = {'(','[','{'};
	static char [] fechamento = {')',']','}'};
	static String estruturais = "()[]{}";
			

	public boolean validar(String palavra) 
	{
		boolean ok;
		if (validarPalavra(palavra)){
			System.out.println("OK: A palavra = " + palavra + " esta bem formada!");
			ok = true;
		}
		else	
		{
			System.out.println("Erro: A palavra = " + palavra + " esta mal formada!");
			ok = false;
		}
		return ok;
	}
	
	
	public boolean validarPalavra(String palavra)
	{
		// nivel da estrutura
		int level = 0;

		try
		{
			for (int i = 0; i < palavra.length(); i++)
			{
				level += validarCaracter(palavra.charAt(i),level,i);
			}
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;		
	}
	
	
	public int validarCaracter(char caracter,int level,int posicao) throws Exception
	{
		
        if (isEstrutural(caracter))
        {
        	// é um caracter de abertura correto para este nivel?
    		if (level < abertura.length && abertura[level] == caracter)
    			return 1;

    		 
            // é um caracter de fechamento correto para este nivel?		
    		if (level > 0 && fechamento[level-1] == caracter)
    	       return -1;

    		if (isEstruturalProibido(caracter,level))
    		{
    			// lança erro se caracter proibido para este nivel
    			throw new Exception("Palavra Mal Formada!");
    		}
        }

        // segue validando a palavra sem mudar o nivel
    	return 0;
	}
	

	public boolean isEstrutural(char caracter) throws Exception
	{
		for (int i = 0; i < estruturais.length(); i++)
		{
			if (caracter == estruturais.charAt(i))
			    return true;
				
		}
        return false;		
	}

	public boolean isEstruturalProibido(char caracter,int level) throws Exception
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
