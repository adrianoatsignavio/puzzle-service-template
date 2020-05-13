package com.signavio.template;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.signavio")
public class NamingConventionsTest {
	
	@ArchTest
	static final ArchRule persistanceDtoNaming = classes().that()
			.resideInAPackage("..persistence.dto..")
			.should().haveSimpleNameEndingWith("Info")
			.orShould().haveSimpleNameEndingWith("Builder");
	
	@ArchTest
	static final ArchRule restDtoNaming = classes().that()
			.resideInAPackage("..rest.dto..")
			.should().haveSimpleNameEndingWith("Resource")
			.orShould().haveSimpleNameEndingWith("Builder");
	
}
