package com.signavio.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.signavio")
public class NamingConventionsTest {
	
	@ArchTest
	static final ArchRule persistanceDtoNaming = classes().that()
			.resideInAPackage("..persistence.dto..")
			.should().haveSimpleNameEndingWith("Info");
	
	@ArchTest
	static final ArchRule restDtoNaming = classes().that()
			.resideInAPackage("..rest.dto..")
			.should().haveSimpleNameEndingWith("Resource");
	
}
