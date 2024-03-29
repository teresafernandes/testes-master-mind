package testes;

import static org.junit.Assert.*;
import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Retorno;

import org.junit.Before;
import org.junit.Test;

public class RetornoTestes {

	Retorno retorno;
	
	@Before
	public void setUp() throws Exception {
		retorno = new Retorno();
	}

	
	/*@Test
	public void adicionarPinoTestePinoCorPretoQuantidadePinosZero() throws CorInvalidaException {
		retorno.setPinosInseridos(0);
		retorno.adicionarPino("preto");
		
		assertEquals("preto", retorno.getRetorno()[0]);
	}*/

	@Test
	public void adicionarPinoTestePinoCorPretoQuantidadePinosZeroStringConcat() throws CorInvalidaException {
		retorno.setPinosInseridos(0);
		String preto = "pre"; preto.concat("to");
		retorno.adicionarPino(preto);
		
		assertEquals(preto, retorno.getRetorno()[0]);
	}


	@Test
	public void adicionarPinoTestePinoCorBrancoQuantidadePinosTres() throws CorInvalidaException {
		String [] retornoString = {"preto", "branco", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);		
		retorno.setPinosInseridos(3);
		String branco = "bran"; branco.concat("co");
		retorno.adicionarPino(branco);
		
		assertEquals(branco, retorno.getRetorno()[3]);
	}
	
	@Test (expected=CorInvalidaException.class)
	public void adicionarPinoTestePinoCorAmareloQuantidadePinosTres() throws CorInvalidaException {
		String [] retornoString = {"preto", "branco", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);		
		retorno.setPinosInseridos(3);
		String amarelo = "amarel"; amarelo.concat("o");
		retorno.adicionarPino(amarelo);
		
		fail("Cor 'amarelo' � invalida, mas nenhuma exce��o foi lan�ada");
	}
	
	@Test (expected=PosicaoInvalidaException.class)
	public void adicionarPinoTestePinoCorRoxoQuantidadePinosQuatro() throws CorInvalidaException, PosicaoInvalidaException {
		String [] retornoString = {"preto", "branco", "branco", "branco"};
		retorno.setRetorno(retornoString);		
		retorno.setPinosInseridos(5);
		retorno.adicionarPino("branco");
		
		fail("A quantidade de pinos inserido no retorno excede o tamanho do array, mas n�o foi lan�ada nenhuma exce��o");
	}
	
	@Test  (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoNegativa() throws PosicaoInvalidaException{
		String [] retornoString = {"preto", "preto", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);
		
		retorno.getPino(-1);
		fail("O numero da posi��o n�o est� no intervalo 0<=posi��o<=3");
	}
	
	@Test
	public void getPinoTestePosicaoEntreZeroETres() throws PosicaoInvalidaException {
		
		String [] retornoString = {"preto", "preto", "branco", "branco"};
		retorno.setRetorno(retornoString);
		
		assertEquals("branco",retorno.getPino(3));
	}
	
	@Test  (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoMaiorQueTres() throws PosicaoInvalidaException {
		String [] retornoString = {"preto", "preto", "branco", "branco"};
		retorno.setRetorno(retornoString);
		
		retorno.getPino(5);
		fail("O numero da posi��o n�o est� no intervalo 0<=posi��o<=3");
	}
	
	@Test
	public void getPinoTestePosicaoIgualZero() throws PosicaoInvalidaException {
		
		String [] retornoString = {"nenhum", "nenhum", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);
		
		assertEquals("nenhum",retorno.getPino(0));
	}

}
