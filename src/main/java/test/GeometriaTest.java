package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import JUnit.Junit09_Geometria.dto.Geometria;

class GeometriaTest {
	
	Geometria geo;

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@BeforeEach
	public void before() {
		geo = new Geometria();
	}
	
	@Test
	public void testAreaCuadrado() {
		int esperado = geo.areacuadrado(2);
		int resultado = 4;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaCirculo() {
		double esperado = geo.areaCirculo(2);
		double resultado = 12.57;
		int delta = 1;
		assertEquals(esperado, resultado, delta);
	}
	
	@Test
	public void testAreaTriangulo() {
		int esperado = geo.areatriangulo(4,4);
		int resultado = 8;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaRectangulo() {
		int esperado = geo.arearectangulo(2, 2);
		int resultado = 4;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaPentagono() {
		int esperado = geo.areapentagono(4, 4);
		int resultado = 8;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaRombo() {
		int esperado = geo.arearombo(6, 6);
		int resultado = 18;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaRomboide() {
		int esperado = geo.arearomboide(2, 2);
		int resultado = 4;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAreaTrapecio() {
		int esperado = geo.areatrapecio(3, 3, 3);
		int resultado = 9;
		assertEquals(esperado, resultado);
	}
	
	private static Stream<Arguments> getFigura(){
		return Stream.of(
				Arguments.of(1, "Cuadrado"),
				Arguments.of(2, "Circulo"),
				Arguments.of(3, "Triangulo"),
				Arguments.of(4, "Rectangulo"),
				Arguments.of(5, "Pentagono"),
				Arguments.of(6, "Rombo"),
				Arguments.of(7, "Romboide"),
				Arguments.of(8, "Trapecio"),
				Arguments.of(9, "Default"));		
	}
	
	@ParameterizedTest
	@MethodSource("getFigura")
	public void testFigura(int a, String b) {
		String resultado = geo.figura(a);
		assertEquals(b, resultado);
	}
	
	
	@Test
	public void testGetId() {
		geo = new Geometria(2);
		int esperado = 2;
		int resultado = geo.getId();
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testGetNom() {
		geo = new Geometria(2);
		String esperado = "Circulo";
		String resultado = geo.getNom();
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testGetArea() {
		geo.setArea(geo.areacuadrado(2));
		int esperado = 4;
		double resultado = geo.getArea();
		int delta = 1;
		assertEquals(esperado, resultado, delta);
	}
	
	@Test
	public void testApp() {
		geo = new Geometria(2);
		double areaCirc= geo.areaCirculo(2);
		geo.setArea(areaCirc);
		String esperado = "Geometria [id=2, nom=Circulo, area=12.5664]";
		String resultado = geo.toString();
		assertEquals(esperado, resultado);
	}
}
