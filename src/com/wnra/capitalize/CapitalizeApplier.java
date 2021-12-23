package com.wnra.capitalize;

import java.util.List;
import java.util.stream.Collectors;

import com.wnra.capitalize.util.Formatacoes;

public class CapitalizeApplier {

	public static <T> void injectFormatting(T objeto) {
		Class<?> classe = objeto.getClass();
		var camposDeclarados = List.of(classe.getDeclaredFields());
		var camposCapitalize = camposDeclarados.stream()
				.filter(field -> field.isAnnotationPresent(Capitalize.class) && field.getGenericType() == String.class)
				.collect(Collectors.toList());

		camposCapitalize.forEach(field -> {
			try {
				field.setAccessible(true);
				field.set(objeto, Formatacoes.capitalize(field.get(objeto).toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public static <T> void injectFormatting(T ...objetos) {
		for (var objeto : objetos) {
		Class<?> classe = objeto.getClass();
		var camposDeclarados = List.of(classe.getDeclaredFields());
		var camposCapitalize = camposDeclarados.stream()
				.filter(field -> field.isAnnotationPresent(Capitalize.class) && field.getGenericType() == String.class)
				.collect(Collectors.toList());

		camposCapitalize.forEach(field -> {
			try {
				field.setAccessible(true);
				field.set(objeto, Formatacoes.capitalize(field.get(objeto).toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		}
	}

}
