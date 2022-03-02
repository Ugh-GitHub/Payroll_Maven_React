package com.ughgithub.payroll;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@PreAuthorize("hasRole('ROLE_MANAGER')") // <1>
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	//The repository extends Spring Data Commons' CrudRepository and plugs in the type of the domain object and its primary key

	@Override
	@PreAuthorize("#employee?.manager == null or #employee?.manager?.name == authentication?.name")
	Employee save(@Param("employee") Employee employee);

	@Override
	@PreAuthorize("@employeeRepository.findById(#id)?.manager?.name == authentication?.name")
	void deleteById(@Param("id") Long id);

	@Override
	@PreAuthorize("#employee?.manager?.name == authentication?.name")
	void delete(@Param("employee") Employee employee);

}
