package com.signavio.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "com.signavio")
public class ArchitectureTest {
	
	@ArchTest
	static final ArchRule portsContainOnlyInterfaces = classes().that().resideInAPackage("..core.usecase.port..")
			.should().beInterfaces();
	
	/**
	 * It is not technically possible to verify that classes in "core" does not use Lombok, because
	 * because it is a runtime check but Lombok generate the class during the compile time,
	 * and a runtime code does not have any lombok annotations
	 */
	@ArchTest
	static final ArchRule protectCoreBusiness = noClasses().that().resideInAPackage("..core..")
			.should().accessClassesThat().resideInAPackage("io.micronaut..")
			.orShould().accessClassesThat().resideInAPackage("org.springframework..")
			.orShould().accessClassesThat().resideInAPackage("org.immutables..")
			.because("we do not want to couple our core business with frameworks and libraries");
	
	/**
	 * This test fails if there are no classes in layers.
	 * @see <a href="https://www.archunit.org/userguide/html/000_Index.html#_onion_architecture">ArchUnit onion architecture</a>
	 */
	@ArchTest
	static final ArchRule onionArchitecture_check = onionArchitecture()
			.domainModels("com.signavio.core.domain..")
			.domainServices("com.signavio.core.usecase..")
			.applicationServices("com.signavio.application..")
			.adapter("persistence", "com.signavio.adapter.persistence..")
			.adapter("messaging", "com.signavio.adapter.messaging..")
			.adapter("rest", "com.signavio.adapter.rest..");
	
	
}
