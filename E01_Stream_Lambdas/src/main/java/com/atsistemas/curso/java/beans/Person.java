package com.atsistemas.curso.java.beans;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Person {
	@NonNull
	Integer id;
	@NonNull
	String firstName;
	String lastName;
	String email;
	String gender;
	Integer age;
}
