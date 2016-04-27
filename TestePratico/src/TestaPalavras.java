import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestaPalavras {
	private String palavra;
	private Boolean resultadoEsperado;
	private ValidaPalavra validateWord;

	@Before
	public void initialize() {
		validateWord = new ValidaPalavra();
	}

	public TestaPalavras(String palavra, Boolean resultadoEsperado) {
		this.palavra = palavra;
		this.resultadoEsperado = resultadoEsperado;
	}

	@Parameterized.Parameters
	public static Collection wordList() {
		return Arrays.asList(new Object[][] {
				{ "([{a}])", true },
				{ "((((a){{{b,c{([abc)]}", false },
				{ "(a[b,c{abc}])", true },
				 { "abc", true },
				 { "(a[b{c}])", true },
				 { "a[b{c}])", false },
				 { "a([b{c}])", true },
				});
	}

	@Test
	public void testWords() {
		System.out.println();
		assertEquals(resultadoEsperado, validateWord.validar(palavra));
	}
}
