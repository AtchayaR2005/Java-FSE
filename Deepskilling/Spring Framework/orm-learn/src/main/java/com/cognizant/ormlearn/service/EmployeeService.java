package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Employee get(int id) {
        LOGGER.info("Start");
        Employee employee = employeeRepository.findById(id).orElseThrow();
        LOGGER.info("End");
        return employee;
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeRepository.getAllPermanentEmployees();
        LOGGER.info("End");
        return employees;
    }

    @Transactional(readOnly = true)
    public double getAverageSalary() {
        LOGGER.info("Start");
        double average = employeeRepository.getAverageSalary();
        LOGGER.info("End");
        return average;
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(int departmentId) {
        LOGGER.info("Start");
        double average = employeeRepository.getAverageSalary(departmentId);
        LOGGER.info("End");
        return average;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeRepository.getAllEmployeesNative();
        LOGGER.info("End");
        return employees;
    }

    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByCriteria(Integer departmentId, Boolean permanent) {
        LOGGER.info("Start");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();
        if (departmentId != null) {
            predicates.add(builder.equal(root.get("department").get("id"), departmentId));
        }
        if (permanent != null) {
            predicates.add(builder.equal(root.get("permanent"), permanent));
        }

        query.select(root).where(predicates.toArray(Predicate[]::new));
        List<Employee> employees = entityManager.createQuery(query).getResultList();
        LOGGER.info("End");
        return employees;
    }
}
